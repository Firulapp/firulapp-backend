package com.github.firulapp.domain;

import com.github.firulapp.domain.base.BaseParameterDomain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "ayuda")
public class HelpPage extends BaseParameterDomain {

    @Id
    @SequenceGenerator(name = "ayuda_id_seq", sequenceName = "ayuda_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ayuda_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "enlace")
    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
