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
    public List<PetCareDto> getAllPetCares() {
        return petCareMapper.mapAsList(petCareRepository.findAll());
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
