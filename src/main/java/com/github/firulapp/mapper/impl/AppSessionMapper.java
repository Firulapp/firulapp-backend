package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.AppSession;
import com.github.firulapp.dto.AppSessionDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AppSessionMapper implements BaseMapper<AppSession, AppSessionDto> {

    private OrikaBeanMapper mapper;
    public AppSessionMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AppSessionDto> mapAsList(List<AppSession> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppSessionDto mapToDto(AppSession entity) {
        return mapper.map(entity, AppSessionDto.class);
    }

    @Override
    public AppSession mapToEntity(AppSessionDto dto) {
        return mapper.map(dto, AppSession.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
