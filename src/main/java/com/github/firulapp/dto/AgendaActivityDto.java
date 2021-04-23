package com.github.firulapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgendaActivityDto {

    private Long userId;
    private Long petId;
    private Long activityId;
    private Long petMedicalRecordId;
    private Long petVaccinationRecordId;
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
}
