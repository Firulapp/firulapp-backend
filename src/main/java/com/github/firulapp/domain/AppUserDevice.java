package com.github.firulapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "dispositivo_usuario")
public class AppUserDevice {

    @Id
    @SequenceGenerator(name = "dispositivo_usuario_id_seq", sequenceName = "dispositivo_usuario_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "dispositivo_usuario_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_usuario")
    @NotNull
    private Long userId;

    @Column(name = "fecha_asociacion")
    @NotNull
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime asociatedAt;

    @Column(name = "fecha_desasociacion")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime disassociatedAt;

    @Column(name = "fecha_modificacion")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    @Column(name = "usuario_modificacion")
    private Long modifiedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
                .append("asociatedAt", asociatedAt)
                .append("disassociatedAt", disassociatedAt)
                .append("modifiedAt", modifiedAt)
                .append("modifiedBy", modifiedBy)
                .toString();
    }
}
