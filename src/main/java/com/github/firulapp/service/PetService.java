package com.github.firulapp.service;

import com.github.firulapp.dto.AppUserProfileDto;
import com.github.firulapp.dto.PetDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.exceptions.BreedException;
import com.github.firulapp.exceptions.PetException;
import com.github.firulapp.exceptions.SpeciesException;

import java.util.List;

public interface PetService {

    List<PetDto> getPetsByUserId(Long userId) throws PetException;

    List<PetDto> getPetByUserIdAndSpeciesId(Long userId, Long speciesId) throws AppUserException, SpeciesException, PetException;

    PetDto getPetById(Long id) throws PetException;

    PetDto registerOrUpdatePet(PetDto petDto) throws PetException, AppUserException, SpeciesException, BreedException;

    void deletePetRegister(PetDto petDto) throws PetException;

    List<PetDto> getPetByStatus(String status) throws PetException;

    void requestPetAdoption(Long petId, Long requesterId);
}
