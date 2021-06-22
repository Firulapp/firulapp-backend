package com.github.firulapp.domain;

import com.github.firulapp.constants.OrganizationType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "organizacion")
public class Organization {

    @Id
    @SequenceGenerator(name = "solicitud_organizacion_id_seq", sequenceName = "solicitud_organizacion_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "solicitud_organizacion_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private OrganizationType type;

    @Column(name = "descripcion")
    private String description;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
