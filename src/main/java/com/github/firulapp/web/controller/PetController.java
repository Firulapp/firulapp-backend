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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(PetController.class);

    @GetMapping(value = ApiPaths.GET_PET_BY_USER_ID)
    public ResponseEntity<ListResponseDTO> getPetsByUserId(@PathVariable(name = "userId") Long userId){
        try {
            return ResponseEntity.ok(ListResponseDTO.success(petService.getPetsByUserId(userId)));
        } catch (PetException exception) {
            return new ResponseEntity<>(ListResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_USER_AND_SPECIES)
    public ResponseEntity<ListResponseDTO> getPetsByUserAndSpecies(@PathVariable(name = "userId") Long userId,
                                                                   @PathVariable(name = "speciesId") Long speciesId) {
        try {
            return ResponseEntity.ok(ListResponseDTO.success(petService.getPetByUserIdAndSpeciesId(userId, speciesId)));
        } catch (PetException | AppUserException | SpeciesException exception){
            return new ResponseEntity<>(ListResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = ApiPaths.GET_PET_BY_ID)
    public ResponseEntity<ObjectResponseDTO> getPetById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petService.getPetById(id)));
        } catch (PetException exception) {
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = ApiPaths.SAVE)
    public ResponseEntity<ObjectResponseDTO> registerOrUpdatePet(@RequestBody PetDto petDto) {
        try {
            return ResponseEntity.ok(ObjectResponseDTO.success(petService.registerOrUpdatePet(petDto)));
        } catch (PetException | AppUserException | SpeciesException | BreedException exception){
            return new ResponseEntity<>(ObjectResponseDTO.error(exception.getErrorCode(), exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = ApiPaths.DELETE)
    public ResponseEntity<Void> deletePetRegister(@RequestBody PetDto petDto) {
        try {
            petService.deletePetRegister(petDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PetException exception){
            logger.error(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
