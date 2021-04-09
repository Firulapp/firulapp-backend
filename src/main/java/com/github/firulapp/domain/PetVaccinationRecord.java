package com.github.firulapp.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "vacunacion_mascota")
public class PetVaccinationRecord {

    @Id
    @SequenceGenerator(name = "vacunacion_mascota_id_seq", sequenceName = "vacunacion_mascota_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vacunacion_mascota_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_mascota")
    private Long petId;

    @Column(name = "veterinaria")
    private String vet;

    @Column(name = "recordatorio")
    private Boolean reminders;

    @Column(name = "vacuna")
    private String vaccine;

    @Column(name = "fecha_vacunacion")
    private LocalDate vaccinationDate;

    @Column(name = "observacion")
    private String observation;

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

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public Boolean getReminders() {
        return reminders;
    }

    public void setReminders(Boolean reminders) {
        this.reminders = reminders;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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
