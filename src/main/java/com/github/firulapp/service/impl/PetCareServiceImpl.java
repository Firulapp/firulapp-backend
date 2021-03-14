package com.github.firulapp.service.impl;

import com.github.firulapp.domain.PetCare;
import com.github.firulapp.dto.PetCareDto;
import com.github.firulapp.exceptions.PetCareException;
import com.github.firulapp.mapper.impl.PetCareMapper;
import com.github.firulapp.repository.PetCareRepository;
import com.github.firulapp.service.PetCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PetCareServiceImpl implements PetCareService {

    @Autowired
    private PetCareRepository petCareRepository;

    @Autowired
    private PetCareMapper petCareMapper;

    @Override
    public List<PetCareDto> getAllPetCares(){
        return petCareMapper.mapAsList(petCareRepository.findAll());
    }

    @Override
    public PetCareDto getPetCareById(Long id) throws PetCareException {
        Optional<PetCare> petCare = petCareRepository.findById(id);
        return petCare.map(pc -> petCareMapper.mapToDto(pc)).orElseThrow(PetCareException.notFound(id));
    }

    @Override
    public PetCareDto savePetCare(PetCareDto petCareDto) {
        if(petCareDto.getId() != null) {
            petCareDto.setModifiedAt(LocalDateTime.now());
            return petCareMapper.mapToDto(petCareMapper.mapToEntity(petCareDto));
        }else{
            PetCare petCare = petCareMapper.mapToEntity(petCareDto);
            petCare.setStatus(Boolean.TRUE);
            petCare.setCreatedAt(LocalDateTime.now());
            return petCareMapper.mapToDto(petCareRepository.save(petCare));
        }
    }

    @Override
    public void delete(PetCareDto petCareDto) {
        Optional<PetCare> petCare = petCareRepository.findById(petCareDto.getId());
        petCare.ifPresent(value -> petCareRepository.delete(petCare.get()));
    }
}
