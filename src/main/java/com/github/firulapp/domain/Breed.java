package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "raza_animal")
public class Breed extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "raza_animal_id_seq", sequenceName = "raza_animal_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "raza_animal_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_especie")
    @NotNull
    private Long speciesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }
}
