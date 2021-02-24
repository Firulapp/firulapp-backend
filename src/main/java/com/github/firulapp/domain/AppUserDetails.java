package com.github.firulapp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "detalle_usuario")
public class AppUserDetails {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToOne
    @NotNull
    private AppUser userId;

    @Column(name = "nro_documento")
    @NotNull
    private String document;

    @Column(name = "tipo_documento")
    @NotNull
    private String documentType;

    @Column(name = "nombres")
    @NotNull
    private String name;

    @Column(name = "apellidos")
    @NotNull
    private String surname;

    @Column(name = "ciudad")
    @NotNull
    private String city;

    @Column(name = "foto_perfil")
    private byte[] profilePicture;

    @Column(name = "fecha_nacimiento")
    @NotNull
    private LocalDate birthDate;

    @Column(name = "notificaciones")
    @NotNull
    private boolean notifications;

    @Column(name = "fecha_creacion")
    @NotNull
    private LocalDateTime createdAt;

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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
                .append("document", document)
                .append("documentType", documentType)
                .append("name", name)
                .append("surname", surname)
                .append("city", city)
                .append("profilePicture", profilePicture)
                .append("birthDate", birthDate)
                .append("notifications", notifications)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("modifiedBy", modifiedBy)
                .toString();
    }
}
