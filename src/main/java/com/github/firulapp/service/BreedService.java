package com.github.firulapp.service;

import com.github.firulapp.domain.Species;
import com.github.firulapp.dto.BreedDto;
import com.github.firulapp.exceptions.BreedException;

import java.util.List;

public interface BreedService {

    List<BreedDto> getAllBreeds();

    BreedDto getBreedById(Long id) throws BreedException;

    BreedDto saveBreed(BreedDto breedDto);

    List<BreedDto> getBreedBySpeciesId(Long speciesId);
}
