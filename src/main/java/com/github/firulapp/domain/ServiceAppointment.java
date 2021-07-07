package com.github.firulapp.domain;

import com.github.firulapp.constants.AppointmentStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "turno_servicio")
public class ServiceAppointment {

    @Id
    @SequenceGenerator(name = "turno_servicio_id_seq", sequenceName = "turno_servicio_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "turno_servicio_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_servicio")
    private Long serviceId;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "id_mascota")
    private Long petId;

    @Column(name = "fecha_turno")
    private LocalDate appointmentDate;

    @Column(name = "estado")
    private AppointmentStatus status;

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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
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
