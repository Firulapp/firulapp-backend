package com.github.firulapp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "dispositivo_usuario")
public class AppUserDevice {

    @Id
    @Column(name = "id")
    @NotNull
    private Long id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    @NotNull
    private AppUser userId;

    @Column(name = "fecha_asociacion")
    @NotNull
    private LocalDateTime asociatedAt;

    @Column(name = "fecha_desasociacion")
    private LocalDateTime disassociatedAt;

    @Column(name = "fecha_modificacion")
    private LocalDateTime modifiedAt;

    @Column(name = "usuario_modificacion")
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
