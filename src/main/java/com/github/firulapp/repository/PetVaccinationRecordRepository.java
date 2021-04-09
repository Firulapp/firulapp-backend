package com.github.firulapp.repository;

import com.github.firulapp.domain.PetVaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PetVaccinationRecordRepository extends JpaRepository<PetVaccinationRecord, Long> {

    List<PetVaccinationRecord> findByPetId(Long petId);
}
