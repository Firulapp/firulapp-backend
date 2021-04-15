package com.github.firulapp.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "ficha_medica_mascota")
public class PetMedicalRecord {

    @Id
    @SequenceGenerator(name = "ficha_medica_mascota_id_seq", sequenceName = "ficha_medica_mascota_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ficha_medica_mascota_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_mascota")
    private Long petId;

    @Column(name = "veterinaria")
    private String vet;

    @Column(name = "tratamiento")
    private String treatment;

    @Column(name = "observacion")
    private String observations;

    @Column(name = "diagnostico")
    private String diagnostic;

    @Column(name = "recordatorio_tratamiento")
    private Boolean treatmentReminder;

    @Column(name = "peso_mascota")
    private Long petWeight;

    @Column(name = "medida")
    private Long petHeight;

    @Column(name = "fecha_consulta")
    private LocalDate consultedAt;

    @Column(name = "fecha_creacion")
    private LocalDateTime createdAt;

    @Column(name = "usuario_creacion")
    private Long createdBy;

    @Column(name = "fecha_modificacion")
    private LocalDateTime modifiedAt;

    @Column(name = "usuario_modificacion")
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

    public void setPetId(Long idMascota) {
        this.petId = idMascota;
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
