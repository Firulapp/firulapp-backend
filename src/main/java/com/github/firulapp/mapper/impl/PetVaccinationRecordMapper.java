package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.PetVaccinationRecord;
import com.github.firulapp.dto.PetVaccinationRecordDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PetVaccinationRecordMapper implements BaseMapper<PetVaccinationRecord, PetVaccinationRecordDto> {

    private OrikaBeanMapper mapper;

    public PetVaccinationRecordMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PetVaccinationRecordDto> mapAsList(List<PetVaccinationRecord> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetVaccinationRecordDto mapToDto(PetVaccinationRecord entity) {
        return mapper.map(entity, PetVaccinationRecordDto.class);
    }

    @Override
    public PetVaccinationRecord mapToEntity(PetVaccinationRecordDto dto) {
        return mapper.map(dto, PetVaccinationRecord.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
