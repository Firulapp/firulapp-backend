package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.ServiceEntity;
import com.github.firulapp.dto.ServiceDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ServiceMapper implements BaseMapper<ServiceEntity, ServiceDto> {

    private OrikaBeanMapper mapper;

    public ServiceMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ServiceDto> mapAsList(List<ServiceEntity> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDto mapToDto(ServiceEntity entity) {
        return mapper.map(entity, ServiceDto.class);
    }

    @Override
    public ServiceEntity mapToEntity(ServiceDto dto) {
        return mapper.map(dto, ServiceEntity.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
