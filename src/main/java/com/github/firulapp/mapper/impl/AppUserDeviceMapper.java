package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.AppUserDevice;
import com.github.firulapp.dto.AppUserDeviceDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AppUserDeviceMapper implements BaseMapper<AppUserDevice, AppUserDeviceDto> {

    private OrikaBeanMapper mapper;

    public AppUserDeviceMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AppUserDeviceDto> mapAsList(List<AppUserDevice> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDeviceDto mapToDto(AppUserDevice entity) {
        return mapper.map(entity, AppUserDeviceDto.class);
    }

    @Override
    public AppUserDevice mapToEntity(AppUserDeviceDto dto) {
        return mapper.map(dto, AppUserDevice.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
