package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.ServiceAppointment;
import com.github.firulapp.dto.ServiceAppointmentDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ServiceAppointmentMapper implements BaseMapper<ServiceAppointment, ServiceAppointmentDto> {

    private final OrikaBeanMapper mapper;

    public ServiceAppointmentMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ServiceAppointmentDto> mapAsList(List<ServiceAppointment> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceAppointmentDto mapToDto(ServiceAppointment entity) {
        return mapper.map(entity, ServiceAppointmentDto.class);
    }

    @Override
    public ServiceAppointment mapToEntity(ServiceAppointmentDto dto) {
        return mapper.map(dto, ServiceAppointment.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
