package com.github.firulapp.dto;

import com.github.firulapp.domain.AppUser;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class AppUserDeviceDto {

    private Long id;
    private AppUser userId;
    private LocalDateTime asociatedAt;
    private LocalDateTime disassociatedAt;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

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

    public LocalDateTime getAsociatedAt() {
        return asociatedAt;
    }

    public void setAsociatedAt(LocalDateTime asociatedAt) {
        this.asociatedAt = asociatedAt;
    }

    public LocalDateTime getDisassociatedAt() {
        return disassociatedAt;
    }

    public void setDisassociatedAt(LocalDateTime disassociatedAt) {
        this.disassociatedAt = disassociatedAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("asociatedAt", asociatedAt)
                .append("disassociatedAt", disassociatedAt)
                .append("modifiedAt", modifiedAt)
                .append("modifiedBy", modifiedBy)
                .toString();
    }
}
