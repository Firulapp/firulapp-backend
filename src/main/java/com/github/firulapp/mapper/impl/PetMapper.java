package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.Pet;
import com.github.firulapp.dto.PetDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PetMapper implements BaseMapper<Pet, PetDto> {

    private final OrikaBeanMapper mapper;

    public PetMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PetDto> mapAsList(List<Pet> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetDto mapToDto(Pet entity) {
        return mapper.map(entity, PetDto.class);
    }

    @Override
    public Pet mapToEntity(PetDto dto) {
        return mapper.map(dto, Pet.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
