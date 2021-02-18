package com.github.firulapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "app_role",
        uniqueConstraints = {@UniqueConstraint(name = "app_role_role_name_key",columnNames = "role_name")})
public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
