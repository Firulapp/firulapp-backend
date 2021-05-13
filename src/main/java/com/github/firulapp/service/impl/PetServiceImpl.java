package com.github.firulapp.service.impl;

import com.github.firulapp.constants.PetStatus;
import com.github.firulapp.domain.Pet;
import com.github.firulapp.dto.AppUserProfileDto;
import com.github.firulapp.dto.CityDto;
import com.github.firulapp.dto.FosterRegisterDto;
import com.github.firulapp.dto.PetDto;
import com.github.firulapp.exceptions.*;
import com.github.firulapp.mapper.impl.FosterRegisterMapper;
import com.github.firulapp.mapper.impl.PetMapper;
import com.github.firulapp.repository.FosterPetRepository;
import com.github.firulapp.repository.PetRepository;
import com.github.firulapp.service.*;
import com.github.firulapp.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private BreedService breedService;

    @Autowired
    private CityService cityService;

    @Autowired
    private FosterPetRepository fosterPetRepository;

    @Autowired
    private FosterRegisterMapper fosterRegisterMapper;

    private EmailUtils emailUtils = new EmailUtils();

    @Override
    public List<PetDto> getPetsByUserId(Long userId) throws PetException {
        try {
            return petMapper.mapAsList(petRepository.findByUserId(userId));
        }catch (Exception e){
            throw PetException.userPetsNotFound(userId);
        }
    }

    @Override
    public List<PetDto> getPetByUserIdAndSpeciesId(Long userId, Long speciesId)
            throws AppUserException, SpeciesException, PetException {
        if(appUserService.getUserById(userId) != null && speciesService.getSpeciesById(speciesId)!=null) {
            return petMapper.mapAsList(petRepository.findByUserIdAndSpeciesId(userId, speciesId));
        }else{
            throw PetException.userPetsNotFound(userId);
        }
    }

    @Override
    public PetDto getPetById(Long id) throws PetException {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.map(value -> petMapper.mapToDto(pet.get())).orElseThrow(PetException.notFound(id));
    }

    @Override
    public PetDto registerOrUpdatePet(PetDto petDto)
            throws PetException, AppUserException, SpeciesException, BreedException {

        if(appUserService.getUserById(petDto.getUserId()) != null
                && speciesService.getSpeciesById(petDto.getSpeciesId())!=null
                && breedService.getBreedById(petDto.getBreedId()) != null) {
            Pet pet = petMapper.mapToEntity(petDto);
            if (pet.getId() != null) {
                pet.setModifiedAt(LocalDateTime.now());
            }else{
                pet.setCreatedAt(LocalDateTime.now());
            }
            return petMapper.mapToDto(petRepository.save(pet));
        }else{
            throw PetException.saveException();
        }
    }

    @Override
    public void deletePetRegister(PetDto petDto) throws PetException {
        try {
            petRepository.delete(petMapper.mapToEntity(petDto));
        }catch(Exception e){
            throw PetException.deleteFailed(petDto);
        }
    }

    @Override
    public List<PetDto> getPetByStatus(String status) throws PetException {
        try {
            return petMapper.mapAsList(petRepository.findByStatus(PetStatus.valueOf(status.toUpperCase(Locale.ROOT))));
        } catch (Exception e) {
            throw PetException.notFound();
        }
    }

    @Override
    public void requestPetAdoption(Long petId, Long requesterId) {
        try {
            PetDto pet = getPetById(petId);
            AppUserProfileDto petOwner = appUserService.getUserById(pet.getUserId());

            if(!requesterId.equals(petOwner.getId())){
                AppUserProfileDto adoptingUser = appUserService.getUserById(requesterId);
                CityDto cityDto = cityService.getCityById(adoptingUser.getCity());
                emailUtils.sendAdoptionRequest(pet, adoptingUser, petOwner, cityDto);
            } else {
                throw PetException.adoptionError(requesterId, petId, pet.getUserId());
            }
        } catch (AppUserException | PetException | CityException | EmailUtilsException e){
            e.printStackTrace();
        }
    }


    @Override
    public FosterRegisterDto requestFosterPet(Long petId, Long requesterId, int amount) throws PetException {
        try {
            PetDto pet = getPetById(petId);
            AppUserProfileDto petOwner = appUserService.getUserById(pet.getUserId());

            if(!requesterId.equals(petOwner.getId())){
                AppUserProfileDto adoptingUser = appUserService.getUserById(requesterId);
                CityDto cityDto = cityService.getCityById(adoptingUser.getCity());
                emailUtils.sendFosterRequest(pet, adoptingUser, petOwner, cityDto, amount);

                FosterRegisterDto fosterRegisterDto = new FosterRegisterDto();
                fosterRegisterDto.setPetId(petId);
                fosterRegisterDto.setFosterUserId(requesterId);
                fosterRegisterDto.setAmount(amount);
                fosterRegisterDto.setCreatedAt(LocalDateTime.now());
                fosterRegisterDto.setCreatedBy(requesterId);
                return fosterRegisterMapper.mapToDto(fosterPetRepository.save(fosterRegisterMapper.mapToEntity(fosterRegisterDto)));
            } else {
                throw PetException.fosterError(requesterId, petId, pet.getUserId());
            }
        } catch (AppUserException | PetException | CityException | EmailUtilsException e){
            throw PetException.fosterError(requesterId, petId);
        }
    }
}
