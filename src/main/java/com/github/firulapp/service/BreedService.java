package com.github.firulapp.service;

import com.github.firulapp.domain.Species;
import com.github.firulapp.dto.BreedDto;

import java.util.List;

public interface BreedService {

    List<BreedDto> getAllBreeds();

    BreedDto getBreedById(Long id);

    BreedDto saveBreed(BreedDto breedDto);

    List<BreedDto> getBreedBySpeciesId(Species speciesId);
}
