package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.AppUserDetails;
import com.github.firulapp.domain.ServiceType;
import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.dto.ServiceTypeDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServiceTypeMapper implements BaseMapper<ServiceType, ServiceTypeDto> {

    private OrikaBeanMapper mapper;

    public ServiceTypeMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ServiceTypeDto> mapAsList(List<ServiceType> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceTypeDto mapToDto(ServiceType entity) {
        return mapper.map(entity, ServiceTypeDto.class);
    }

    @Override
    public ServiceType mapToEntity(ServiceTypeDto dto) {
        return mapper.map(dto, ServiceType.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
