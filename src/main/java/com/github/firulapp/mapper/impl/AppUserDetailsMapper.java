package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.AppUserDetails;
import com.github.firulapp.dto.AppUserDetailsDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AppUserDetailsMapper implements BaseMapper<AppUserDetails, AppUserDetailsDto> {

    private OrikaBeanMapper mapper;

    public AppUserDetailsMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AppUserDetailsDto> mapAsList(List<AppUserDetails> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDetailsDto mapToDto(AppUserDetails entity) {
        return mapper.map(entity, AppUserDetailsDto.class);
    }

    @Override
    public AppUserDetails mapToEntity(AppUserDetailsDto dto) {
        return mapper.map(dto, AppUserDetails.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
