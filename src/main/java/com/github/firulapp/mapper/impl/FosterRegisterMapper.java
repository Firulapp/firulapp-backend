package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.FosterRegister;
import com.github.firulapp.dto.FosterRegisterDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FosterRegisterMapper implements BaseMapper<FosterRegister, FosterRegisterDto> {

    private OrikaBeanMapper mapper;

    public FosterRegisterMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<FosterRegisterDto> mapAsList(List<FosterRegister> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FosterRegisterDto mapToDto(FosterRegister entity) {
        return mapper.map(entity, FosterRegisterDto.class);
    }

    @Override
    public FosterRegister mapToEntity(FosterRegisterDto dto) {
        return mapper.map(dto, FosterRegister.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
