package com.github.firulapp.web.controller;

import com.github.firulapp.constants.ApiPaths;
import com.github.firulapp.dto.PetDto;
import com.github.firulapp.exceptions.AppUserException;
import com.github.firulapp.exceptions.BreedException;
import com.github.firulapp.exceptions.PetException;
import com.github.firulapp.exceptions.SpeciesException;
import com.github.firulapp.service.PetService;
import com.github.firulapp.web.response.ListResponseDTO;
import com.github.firulapp.web.response.ObjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {ApiPaths.PET_ENDPOINTS_URL})
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping(value = ApiPaths.GET_PET_BY_USER_ID)
    public ResponseEntity<ListResponseDTO> getPetsByUserId(@PathVariable(name = "userId") Long userId)
            throws PetException {
        return ResponseEntity.ok(ListResponseDTO.success(petService.getPetsByUserId(userId)));
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_USER_AND_SPECIES)
    public ResponseEntity<ListResponseDTO> getPetsByUserAndSpecies(@PathVariable(name = "userId") Long userId,
                                                                   @PathVariable(name = "speciesId") Long speciesId)
            throws PetException, AppUserException, SpeciesException {
        return ResponseEntity.ok(ListResponseDTO.success(petService.getPetByUserIdAndSpeciesId(userId, speciesId)));
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getPetById(@PathVariable(name = "id") Long id) throws PetException {
        return ResponseEntity.ok(ObjectResponseDTO.success(petService.getPetById(id)));
    }

    @PostMapping(value = ApiPaths.SAVE_OR_UPDATE_PET_REGISTER)
    public ResponseEntity<ObjectResponseDTO> registerOrUpdatePet(@RequestBody PetDto petDto)
            throws PetException, AppUserException, SpeciesException, BreedException {
        return ResponseEntity.ok(ObjectResponseDTO.success(petService.registerOrUpdatePet(petDto)));
    }

    @DeleteMapping(value = ApiPaths.DELETE_PET_REGISTER)
    public ResponseEntity<Void> deletePetRegister(@RequestBody PetDto petDto) throws PetException {
        petService.deletePetRegister(petDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
