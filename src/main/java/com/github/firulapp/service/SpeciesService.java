package com.github.firulapp.service;

import com.github.firulapp.dto.SpeciesDto;
import com.github.firulapp.exceptions.SpeciesException;

import java.util.List;

public interface SpeciesService {

    List<SpeciesDto> getAllSpecies(Integer listStart, Integer listEnd) throws SpeciesException;

    SpeciesDto getSpeciesById(Long id) throws SpeciesException;

    SpeciesDto saveSpecies(SpeciesDto speciesDto);
}
