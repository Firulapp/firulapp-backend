package com.github.firulapp.mapper.impl;

import com.github.firulapp.domain.PetMedicalRecord;
import com.github.firulapp.dto.PetMedicalRecordDto;
import com.github.firulapp.mapper.BaseMapper;
import com.github.firulapp.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PetMedicalRecordMapper implements BaseMapper<PetMedicalRecord, PetMedicalRecordDto> {

    private OrikaBeanMapper mapper;

    public PetMedicalRecordMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<PetMedicalRecordDto> mapAsList(List<PetMedicalRecord> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetMedicalRecordDto mapToDto(PetMedicalRecord entity) {
        return mapper.map(entity, PetMedicalRecordDto.class);
    }

    @Override
    public PetMedicalRecord mapToEntity(PetMedicalRecordDto dto) {
        return mapper.map(dto, PetMedicalRecord.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
