package com.github.firulapp.service;

import com.github.firulapp.dto.PetMedicalRecordDto;
import com.github.firulapp.exceptions.PetMedicalRecordException;

import java.time.LocalDate;
import java.util.List;

public interface PetMedicalRecordService {

    List<PetMedicalRecordDto> getPetMedicalRecordsByPetId(Long petId);

    List<PetMedicalRecordDto> getPetMedicalRecordsByPetIdAndConsultDate(Long petId, LocalDate consultDate);

    PetMedicalRecordDto getPetMedicalRecordById(Long id) throws PetMedicalRecordException;

    PetMedicalRecordDto savePetMedicalRecord(PetMedicalRecordDto petMedicalRecordDto) throws PetMedicalRecordException;

    void deletePetMedicalRecord(PetMedicalRecordDto petMedicalRecordDto);
}
