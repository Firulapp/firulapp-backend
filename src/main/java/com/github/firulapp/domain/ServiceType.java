package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "tipo_servicio")
public class ServiceType extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "tipo_servicio_id_seq", sequenceName = "tipo_servicio_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tipo_servicio_id_seq")
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
