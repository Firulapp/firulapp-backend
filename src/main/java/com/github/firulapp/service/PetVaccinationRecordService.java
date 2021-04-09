package com.github.firulapp.service;

import com.github.firulapp.dto.PetVaccinationRecordDto;
import com.github.firulapp.exceptions.PetVaccinationRecordException;

import java.util.List;

public interface PetVaccinationRecordService {

    List<PetVaccinationRecordDto> getPetVaccinationRecordsByPetId(Long petId);

    PetVaccinationRecordDto getPetVaccinationRecordById(Long id) throws PetVaccinationRecordException;

    PetVaccinationRecordDto savePetVaccinationRecord(PetVaccinationRecordDto dto) throws PetVaccinationRecordException;

    void deletePetVaccinationRecord(PetVaccinationRecordDto dto);

}
