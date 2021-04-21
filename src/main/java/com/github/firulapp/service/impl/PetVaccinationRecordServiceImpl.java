package com.github.firulapp.service.impl;

import com.github.firulapp.domain.PetVaccinationRecord;
import com.github.firulapp.dto.PetVaccinationRecordDto;
import com.github.firulapp.exceptions.PetVaccinationRecordException;
import com.github.firulapp.mapper.impl.PetVaccinationRecordMapper;
import com.github.firulapp.repository.PetVaccinationRecordRepository;
import com.github.firulapp.service.PetVaccinationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PetVaccinationRecordServiceImpl implements PetVaccinationRecordService {

    @Autowired
    private PetVaccinationRecordRepository vaccinationRecordRepository;

    @Autowired
    private PetVaccinationRecordMapper vaccinationRecordMapper;

    @Override
    public List<PetVaccinationRecordDto> getPetVaccinationRecordsByPetId(Long petId) {
        return vaccinationRecordMapper.mapAsList(vaccinationRecordRepository.findByPetIdOrderByVaccinationDate(petId));
    }

    @Override
    public PetVaccinationRecordDto getPetVaccinationRecordById(Long id) throws PetVaccinationRecordException {
        Optional<PetVaccinationRecord> petVaccinationRecord = vaccinationRecordRepository.findById(id);
        return petVaccinationRecord.map(record -> vaccinationRecordMapper.mapToDto(record))
                                    .orElseThrow(PetVaccinationRecordException.notFound(id));
    }

    @Override
    public PetVaccinationRecordDto savePetVaccinationRecord(PetVaccinationRecordDto dto) throws PetVaccinationRecordException {
        if(dto.getId() != null){
            if(dto.getModifiedBy()!=null) {
                dto.setModifiedAt(LocalDateTime.now());
            } else {
                throw PetVaccinationRecordException.missingData();
            }
        } else {
            dto.setCreatedAt(LocalDateTime.now());
        }
        return vaccinationRecordMapper.mapToDto(vaccinationRecordRepository.save(vaccinationRecordMapper.mapToEntity(dto)));
    }

    @Override
    public void deletePetVaccinationRecord(PetVaccinationRecordDto dto) {
        Optional<PetVaccinationRecord> petVaccinationRecord = vaccinationRecordRepository.findById(dto.getId());
        petVaccinationRecord.ifPresent(record -> vaccinationRecordRepository.delete(record));
    }
}
