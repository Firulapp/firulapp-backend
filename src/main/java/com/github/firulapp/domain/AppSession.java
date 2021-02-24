package com.github.firulapp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "sesion_usuario")
public class AppSession {

    @Id
    @Column(name = "id")
    @NotNull
    private Long id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    @NotNull
    private AppUser userId;

    @JoinColumn(name = "id_dispositivo", referencedColumnName = "id")
    @ManyToOne
    @NotNull
    private AppUserDevice deviceId;

    @Column(name = "fecha_inicio")
    @NotNull
    private LocalDateTime startDate;

    @Column(name = "fecha_fin")
    private LocalDateTime endDate;

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
