package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.HelpPage;
import com.github.firulapp.dto.HelpPageDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelpPageMapper implements BaseMapper<HelpPage, HelpPageDto> {

    private OrikaBeanMapper mapper;

    public HelpPageMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<HelpPageDto> mapAsList(List<HelpPage> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public HelpPageDto mapToDto(HelpPage entity) {
        return mapper.map(entity, HelpPageDto.class);
    }

    @Override
    public HelpPage mapToEntity(HelpPageDto dto) {
        return mapper.map(dto, HelpPage.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
