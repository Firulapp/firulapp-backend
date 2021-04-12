package com.github.firulapp.service.impl;

import com.github.firulapp.domain.PetMedicalRecord;
import com.github.firulapp.dto.PetMedicalRecordDto;
import com.github.firulapp.exceptions.PetMedicalRecordException;
import com.github.firulapp.mapper.impl.PetMedicalRecordMapper;
import com.github.firulapp.repository.PetMedicalRecordRepository;
import com.github.firulapp.service.PetMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PetMedicalRecordServiceImpl implements PetMedicalRecordService {

    @Autowired
    private PetMedicalRecordMapper petMedicalRecordMapper;

    @Autowired
    private PetMedicalRecordRepository petMedicalRecordRepository;

    @Override
    public List<PetMedicalRecordDto> getPetMedicalRecordsByPetId(Long petId) {
        return petMedicalRecordMapper.mapAsList(petMedicalRecordRepository.findByPetIdOrdeOrderByConsultedAtDesc(petId));
    }

    @Override
    public List<PetMedicalRecordDto> getPetMedicalRecordsByPetIdAndConsultDate(Long petId, LocalDate consultDate) {
        return petMedicalRecordMapper.mapAsList(petMedicalRecordRepository.findByPetIdAndConsultedAt(petId, consultDate));
    }

    @Override
    public PetMedicalRecordDto getPetMedicalRecordById(Long id) throws PetMedicalRecordException {
        Optional<PetMedicalRecord> petMedicalRecord = petMedicalRecordRepository.findById(id);
        return petMedicalRecord.map(record -> petMedicalRecordMapper.mapToDto(record)).orElseThrow(PetMedicalRecordException.notFound(id));
    }

    @Override
    public PetMedicalRecordDto savePetMedicalRecord(PetMedicalRecordDto petMedicalRecordDto) throws PetMedicalRecordException {

        if(petMedicalRecordDto.getId() != null){
            if(petMedicalRecordDto.getModifiedBy()!=null) {
                petMedicalRecordDto.setModifiedAt(LocalDateTime.now());
            }else{
                throw PetMedicalRecordException.missingData();
            }
        } else {
            petMedicalRecordDto.setCreatedAt(LocalDateTime.now());
        }
        return petMedicalRecordMapper.mapToDto(petMedicalRecordRepository.save(petMedicalRecordMapper.mapToEntity(petMedicalRecordDto)));
    }

    @Override
    public void deletePetMedicalRecord(PetMedicalRecordDto petMedicalRecordDto) {
        Optional<PetMedicalRecord> petMedicalRecord = petMedicalRecordRepository.findById(petMedicalRecordDto.getId());
        petMedicalRecord.ifPresent(record -> petMedicalRecordRepository.delete(record));
    }
}
