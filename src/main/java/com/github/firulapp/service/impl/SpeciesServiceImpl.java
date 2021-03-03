package com.github.firulapp.service.impl;

import com.github.firulapp.domain.Species;
import com.github.firulapp.dto.SpeciesDto;
import com.github.firulapp.exceptions.SpeciesException;
import com.github.firulapp.mapper.impl.SpeciesMapper;
import com.github.firulapp.repository.SpeciesRepository;
import com.github.firulapp.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private SpeciesMapper speciesMapper;

    @Override
    public List<SpeciesDto> getAllSpecies() {
        return speciesMapper.mapAsList(speciesRepository.findAll());
    }

    @Override
    public SpeciesDto getSpeciesById(Long id) throws SpeciesException {
        Optional<Species> species = speciesRepository.findById(id);
        return species.map(sp -> speciesMapper.mapToDto(sp)).orElseThrow(SpeciesException.notFound(id));
    }

    @Override
    public SpeciesDto saveSpecies(SpeciesDto speciesDto) {
        return speciesMapper.mapToDto(speciesRepository.save(speciesMapper.mapToEntity(speciesDto)));
    }
}
