package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "cuidado_mascota")
public class PetCare extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "cuidado_mascota_id_seq", sequenceName = "cuidado_mascota_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cuidado_mascota_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "imagen")
    private byte[] picture;

    @Column(name = "enlace")
    private String link;

    @Column(name = "id_especie")
    private Long speciesId;

    @Column(name = "id_raza")
    private Long breedId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
}
