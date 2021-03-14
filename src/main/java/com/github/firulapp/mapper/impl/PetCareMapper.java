package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.PetCare;
import com.github.firulapp.dto.PetCareDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PetCareMapper implements BaseMapper<PetCare, PetCareDto> {

    private OrikaBeanMapper mapper;

    public PetCareMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PetCareDto> mapAsList(List<PetCare> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetCareDto mapToDto(PetCare entity) {
        return mapper.map(entity, PetCareDto.class);
    }

    @Override
    public PetCare mapToEntity(PetCareDto dto) {
        return mapper.map(dto, PetCare.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
