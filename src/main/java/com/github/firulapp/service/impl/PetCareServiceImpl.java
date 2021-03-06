package com.github.firulapp.service.impl;

import com.github.firulapp.domain.PetCare;
import com.github.firulapp.dto.PetCareDto;
import com.github.firulapp.exceptions.PetCareException;
import com.github.firulapp.mapper.impl.PetCareMapper;
import com.github.firulapp.repository.PetCareRepository;
import com.github.firulapp.service.PetCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetCareServiceImpl implements PetCareService {

    @Autowired
    private PetCareRepository petCareRepository;

    @Autowired
    private PetCareMapper petCareMapper;

    @Override
    public List<PetCareDto> getAllPetCares(Integer listStart, Integer listEnd) throws PetCareException{
        List<PetCareDto> allCares= petCareMapper.mapAsList(petCareRepository.findAll());
        if (listStart != null && listEnd!= null && listEnd != 0) {
            if(allCares.size() > listEnd) {
                return allCares.subList(listStart, listEnd);
            }else{
                return allCares;
            }
        }else{
            throw new PetCareException(PetCareException.BASE_ERROR, "Error al mostrar el listado");
        }
    }

    @Override
    public PetCareDto getPetCareById(Long id) throws PetCareException {
        Optional<PetCare> petCare = petCareRepository.findById(id);
        return petCare.map(pc -> petCareMapper.mapToDto(pc)).orElseThrow(PetCareException.notFound(id));
    }

    @Override
    public PetCareDto savePetCare(PetCareDto petCareDto) {
        return petCareMapper.mapToDto(petCareMapper.mapToEntity(petCareDto));
    }
}
