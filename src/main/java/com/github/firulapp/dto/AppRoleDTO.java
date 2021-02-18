package com.github.firulapp.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AppRoleDTO {

    private Long id;
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


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("roleName", roleName)
                .toString();
    }
}
