package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.dto.AppUserDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AppUserMapper implements BaseMapper<AppUser, AppUserDto> {

    private OrikaBeanMapper mapper;

    public AppUserMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AppUserDto> mapAsList(List<AppUser> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDto mapToDto(AppUser entity) {
        return mapper.map(entity, AppUserDto.class);
    }

    @Override
    public AppUser mapToEntity(AppUserDto dto) {
        return mapper.map(dto, AppUser.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
