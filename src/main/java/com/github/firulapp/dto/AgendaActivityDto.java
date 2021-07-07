package com.github.firulapp.dto;

import com.github.firulapp.constants.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgendaActivityDto {

    private Long userId;
    private Long petId;
    private Long activityId;
    private Long petMedicalRecordId;
    private Long petVaccinationRecordId;
    private Long serviceId;
    private Long clientId;
    private Long appointmentId;
    private AppointmentStatus status;
    private String details;
    private LocalDate activityDate;
    private LocalDateTime activityTime;

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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getPetMedicalRecordId() {
        return petMedicalRecordId;
    }

    public void setPetMedicalRecordId(Long petMedicalRecordId) {
        this.petMedicalRecordId = petMedicalRecordId;
    }

    public Long getPetVaccinationRecordId() {
        return petVaccinationRecordId;
    }

    public void setPetVaccinationRecordId(Long petVaccinationRecordId) {
        this.petVaccinationRecordId = petVaccinationRecordId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public LocalDateTime getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(LocalDateTime activityTime) {
        this.activityTime = activityTime;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
