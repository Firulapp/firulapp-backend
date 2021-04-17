package com.github.firulapp.service;

import com.github.firulapp.dto.PetActivityDto;
import com.github.firulapp.exceptions.PetActivityException;

import java.util.List;

public interface PetActivityService {

    PetActivityDto getPetActivityById(Long id) throws PetActivityException;

    List<PetActivityDto> getPetActivitiesByPetId(Long petId);

    PetActivityDto savePetActivity(PetActivityDto petActivityDto) throws PetActivityException;

    void deletePetActivity(Long id) throws PetActivityException;
}
