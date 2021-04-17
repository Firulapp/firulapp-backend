package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.PetActivity;
import com.github.firulapp.dto.PetActivityDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PetActivityMapper implements BaseMapper<PetActivity, PetActivityDto> {

    private OrikaBeanMapper mapper;

    public PetActivityMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PetActivityDto> mapAsList(List<PetActivity> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetActivityDto mapToDto(PetActivity entity) {
        return mapper.map(entity, PetActivityDto.class);
    }

    @Override
    public PetActivity mapToEntity(PetActivityDto dto) {
        return mapper.map(dto, PetActivity.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
