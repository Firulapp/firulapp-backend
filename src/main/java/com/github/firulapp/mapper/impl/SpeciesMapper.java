package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.Species;
import com.github.firulapp.dto.SpeciesDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SpeciesMapper implements BaseMapper<Species, SpeciesDto> {

    private OrikaBeanMapper mapper;

    public SpeciesMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<SpeciesDto> mapAsList(List<Species> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SpeciesDto mapToDto(Species entity) {
        return mapper.map(entity, SpeciesDto.class);
    }

    @Override
    public Species mapToEntity(SpeciesDto dto) {
        return mapper.map(dto, Species.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
