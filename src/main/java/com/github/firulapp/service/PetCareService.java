package com.github.firulapp.service;

import com.github.firulapp.dto.PetCareDto;
import com.github.firulapp.exceptions.PetCareException;

import java.util.List;

public interface PetCareService {

    List<PetCareDto> getAllPetCares(Integer listStart, Integer listEnd) throws PetCareException;

    PetCareDto getPetCareById(Long id) throws PetCareException;

    PetCareDto savePetCare(PetCareDto petCareDto);
}
