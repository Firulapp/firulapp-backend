package com.github.firulapp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "public", name = "mascota")
public class Pet {

    @Id
    @SequenceGenerator(name = "mascota_id_seq", sequenceName = "mascota_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mascota_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "id_especie")
    private Long speciesId;

    @Column(name = "id_raza")
    private Long breedId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "fecha_nacimiento")
    private LocalDate birthDate;

    @Column(name = "edad")
    private int age;

    @Column(name = "tamanho")
    private String petSize;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "direccion")
    private String address;

    @Column(name = "color_primario")
    private String primaryColor;

    @Column(name = "color_secundario")
    private String secondaryColor;

    @Column(name = "estado")
    private Boolean status;

    @Column(name = "fotografia")
    private byte[] picture;

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

    public Long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("speciesId", speciesId)
                .append("breedId", breedId)
                .append("name", name)
                .append("birthDate", birthDate)
                .append("age", age)
                .append("petSize", petSize)
                .append("city", city)
                .append("address", address)
                .append("primaryColor", primaryColor)
                .append("secondaryColor", secondaryColor)
                .append("status", status)
                .append("picture", picture)
                .append("description", description)
                .append("createdAt", createdAt)
                .append("createdBy", createdBy)
                .append("modifiedAt", modifiedAt)
                .append("modifiedBy", modifiedBy)
                .toString();
    }
}
