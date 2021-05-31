package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.ReportPet;
import com.github.firulapp.dto.ReportPetDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ReportPetMapper implements BaseMapper<ReportPet, ReportPetDto> {

    private final OrikaBeanMapper mapper;

    public ReportPetMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ReportPetDto> mapAsList(List<ReportPet> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReportPetDto mapToDto(ReportPet entity) {
        return mapper.map(entity, ReportPetDto.class);
    }

    @Override
    public ReportPet mapToEntity(ReportPetDto dto) {
        return mapper.map(dto, ReportPet.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
