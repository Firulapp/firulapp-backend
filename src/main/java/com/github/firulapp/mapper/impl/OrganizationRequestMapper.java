package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.OrganizationRequest;
import com.github.firulapp.dto.OrganizationRequestDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrganizationRequestMapper  implements BaseMapper<OrganizationRequest, OrganizationRequestDto> {

    private OrikaBeanMapper mapper;

    public OrganizationRequestMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<OrganizationRequestDto> mapAsList(List<OrganizationRequest> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationRequestDto mapToDto(OrganizationRequest entity) {
        return mapper.map(entity, OrganizationRequestDto.class);
    }

    @Override
    public OrganizationRequest mapToEntity(OrganizationRequestDto dto) {
        return mapper.map(dto, OrganizationRequest.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
