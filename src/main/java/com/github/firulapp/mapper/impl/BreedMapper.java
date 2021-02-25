package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.Breed;
import com.github.firulapp.dto.BreedDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BreedMapper implements BaseMapper<Breed, BreedDto> {

    private OrikaBeanMapper mapper;

    public BreedMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<BreedDto> mapAsList(List<Breed> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BreedDto mapToDto(Breed entity) {
        return mapper.map(entity, BreedDto.class);
    }

    @Override
    public Breed mapToEntity(BreedDto dto) {
        return mapper.map(dto, Breed.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
