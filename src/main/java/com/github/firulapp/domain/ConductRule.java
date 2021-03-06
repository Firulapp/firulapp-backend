package com.github.firulapp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "regla_conducta")
public class ConductRule {

    @Id
    @SequenceGenerator(name = "regla_conducta_id_seq", sequenceName = "regla_conducta_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "regla_conducta_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    @NotNull
    private String name;

    @Column(name = "descripcion")
    @NotNull
    private String description;

    @Column(name = "estado")
    @NotNull
    private Boolean status;

    @Column(name = "fecha_creacion")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "usuario_creacion")
    @NotNull
    private Long createdBy;

    @Column(name = "fecha_modificacion")
    private LocalDateTime modifiedAt;

    @Column(name = "usuario_modificacion")
    private Long modifiedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("status", status)
                .append("createdAt", createdAt)
                .append("createdBy", createdBy)
                .append("modifiedAt", modifiedAt)
                .append("modifiedBy", modifiedBy)
                .toString();
    }
}
