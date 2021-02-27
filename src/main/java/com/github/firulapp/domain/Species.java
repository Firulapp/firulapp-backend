package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "public", name = "especie_animal")
public class Species extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "especie_animal_id_seq", sequenceName = "especie_animal_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "especie_animal_id_seq")
    @Column(name = "id")
    private Long id;

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
                .toString();
    }
}
