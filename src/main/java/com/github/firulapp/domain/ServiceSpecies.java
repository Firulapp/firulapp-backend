package com.github.firulapp.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "servicio_especie")
public class ServiceSpecies {

    @Id
    @SequenceGenerator(name = "servicio_especie_id_seq", sequenceName = "servicio_especie_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "servicio_especie_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_servicio")
    private Long serviceId;

    @Column(name = "id_especie")
    private Long speciesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }
}
