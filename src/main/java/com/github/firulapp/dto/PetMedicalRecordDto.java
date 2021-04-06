package com.github.firulapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PetMedicalRecordDto {

    private Long id;
    private Long petId;
    private String vet;
    private String treatment;
    private String observations;
    private String diagnostic;
    private Boolean treatmentReminder;
    private Long petWeight;
    private Long petHeight;
    private LocalDate consultedAt;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime modifiedAt;
    private Long modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Boolean getTreatmentReminder() {
        return treatmentReminder;
    }

    public void setTreatmentReminder(Boolean treatmentReminder) {
        this.treatmentReminder = treatmentReminder;
    }

    public Long getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(Long petWeight) {
        this.petWeight = petWeight;
    }

    public Long getPetHeight() {
        return petHeight;
    }

    public void setPetHeight(Long petHeight) {
        this.petHeight = petHeight;
    }

    public LocalDate getConsultedAt() {
        return consultedAt;
    }

    public void setConsultedAt(LocalDate consultedAt) {
        this.consultedAt = consultedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
