package com.github.firulapp.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AppUserDto {

    private Long id;
    private String username;
    private String email;
    private String encryptedPassword;
    private Boolean enabled;
    private Boolean loguedIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean isLoguedIn() {
        return loguedIn;
    }

    public void setLoguedIn(Boolean loguedIn) {
        this.loguedIn = loguedIn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("username", username)
                .append("email", email)
                .append("encryptedPassword", encryptedPassword)
                .append("enabled", enabled)
                .append("loguedIn", loguedIn)
                .toString();
    }
}
