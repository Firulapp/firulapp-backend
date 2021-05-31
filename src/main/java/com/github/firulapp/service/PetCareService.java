package com.github.firulapp.service;

import com.github.firulapp.dto.PetCareDto;
import com.github.firulapp.exceptions.PetCareException;

import java.util.List;

public interface PetCareService {

    List<PetCareDto> getAllPetCares();

    PetCareDto getPetCareById(Long id) throws PetCareException;

    PetCareDto savePetCare(PetCareDto petCareDto);

    void delete(PetCareDto petCareDto);

    List<PetCareDto> getPetCareBySpeciesAndBreed(Long speciesId, Long breedId) throws PetCareException;
}
