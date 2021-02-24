package com.github.firulapp.dto;

import com.github.firulapp.domain.AppUser;
import com.github.firulapp.domain.AppUserDevice;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class AppSessionDto {

    private Long id;
    private AppUser userId;
    private AppUserDevice deviceId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime modifiedAt;
    private Long modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUserId() {
        return userId;
    }

    public void setUserId(AppUser userId) {
        this.userId = userId;
    }

    public AppUserDevice getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(AppUserDevice deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("deviceId", deviceId)
                .append("startDate", startDate)
                .append("endDate", endDate)
                .append("modifiedAt", modifiedAt)
                .append("modifiedBy", modifiedBy)
                .toString();
    }
}
