package com.github.firulapp.service;

import com.github.firulapp.dto.SpeciesDto;

import java.util.List;

public interface SpeciesService {

    List<SpeciesDto> getAllSpecies();

    SpeciesDto getSpeciesById(Long id);

    SpeciesDto saveSpecies(SpeciesDto speciesDto);
}
