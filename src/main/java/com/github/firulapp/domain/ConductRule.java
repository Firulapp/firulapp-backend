package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "regla_conducta")
public class ConductRule extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "regla_conducta_id_seq", sequenceName = "regla_conducta_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "regla_conducta_id_seq")
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
