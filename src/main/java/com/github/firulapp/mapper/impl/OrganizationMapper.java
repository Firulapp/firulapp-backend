package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.Organization;
import com.github.firulapp.dto.OrganizationDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrganizationMapper implements BaseMapper<Organization, OrganizationDto> {

    private OrikaBeanMapper mapper;

    public OrganizationMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<OrganizationDto> mapAsList(List<Organization> list) {
        return list.stream()
        .filter(Objects::nonNull)
        .map(this::mapToDto)
        .collect(Collectors.toList());
    }

    @Override
    public OrganizationDto mapToDto(Organization entity) {
        return mapper.map(entity, OrganizationDto.class);
    }

    @Override
    public Organization mapToEntity(OrganizationDto dto) {
            return mapper.map(dto, Organization.class);
    }

    @Override
    public MapperFacade getMapper() {
            return null;
    }
}