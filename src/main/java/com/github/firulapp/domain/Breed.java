package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "raza_animal")
public class Breed extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "ayuda_id_seq", sequenceName = "ayuda_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ayuda_id_seq")
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_especie", referencedColumnName = "id")
    @ManyToOne
    @NotNull
    private Species speciesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Species getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Species speciesId) {
        this.speciesId = speciesId;
    }
}
