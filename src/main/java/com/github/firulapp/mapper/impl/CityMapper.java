package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.City;
import com.github.firulapp.dto.CityDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CityMapper implements BaseMapper<City, CityDto> {

    private final OrikaBeanMapper mapper;

    public CityMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<CityDto> mapAsList(List<City> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto mapToDto(City entity) {
        return mapper.map(entity, CityDto.class);
    }

    @Override
    public City mapToEntity(CityDto dto) {
        return mapper.map(dto, City.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
