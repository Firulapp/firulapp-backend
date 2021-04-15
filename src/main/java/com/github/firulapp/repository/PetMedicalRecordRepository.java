package com.github.firulapp.repository;

import com.github.firulapp.domain.PetMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface PetMedicalRecordRepository extends JpaRepository<PetMedicalRecord, Long> {

    List<PetMedicalRecord> findByPetIdOrderByConsultedAtDesc(Long petId);

    List<PetMedicalRecord> findByPetIdAndConsultedAt(Long petId, LocalDate consultedAt);
}
