package com.github.firulapp.service;

import com.github.firulapp.constants.PetStatus;
import com.github.firulapp.dto.FosterRegisterDto;
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

    FosterRegisterDto requestFosterPet(Long petId, Long requesterId, int amount) throws PetException;

    PetDto adoptPet(String adopterUsername, Long petId) throws PetException, AppUserException;

    PetDto updatePetStatus(Long id, PetStatus status, Long modifiedBy) throws PetException;
}
