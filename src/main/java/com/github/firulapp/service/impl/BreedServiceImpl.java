package com.github.firulapp.service.impl;

import com.github.firulapp.domain.Breed;
import com.github.firulapp.domain.Species;
import com.github.firulapp.dto.BreedDto;
import com.github.firulapp.exceptions.BreedException;
import com.github.firulapp.exceptions.SpeciesException;
import com.github.firulapp.mapper.impl.BreedMapper;
import com.github.firulapp.repository.BreedRepository;
import com.github.firulapp.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedServiceImpl implements BreedService {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private BreedMapper breedMapper;

    @Override
    public List<BreedDto> getAllBreeds(Integer listStart, Integer listEnd) throws BreedException {
        List<BreedDto> allBreeds = breedMapper.mapAsList(breedRepository.findAll());
        if ((listStart != null && listEnd!= null) || (listStart == 0 && listEnd == 0)) {
            if(allBreeds.size() > listEnd) {
                return allBreeds.subList(listStart, listEnd);
            }else{
                return allBreeds;
            }
        }else{
            throw new BreedException(BreedException.BASE_ERROR, "Error al mostrar el listado");
        }
    }

    @Override
    public BreedDto getBreedById(Long id) throws BreedException {
        Optional<Breed> breed = breedRepository.findById(id);
        return breed.map(b -> breedMapper.mapToDto(b)).orElseThrow(BreedException.notFound(id));
    }

    @Override
    public BreedDto saveBreed(BreedDto breedDto) {
        return breedMapper.mapToDto(breedRepository.save(breedMapper.mapToEntity(breedDto)));
    }

    @Override
    public List<BreedDto> getBreedBySpeciesId(Long speciesId) {
        return breedMapper.mapAsList(breedRepository.findBySpeciesId(speciesId));
    }
}
