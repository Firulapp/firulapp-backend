package com.github.firulapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(schema = "public", name = "usuario")
public class AppUser {
    @Id
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usuario_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "correo", length = 100, nullable = false)
    private String email;

    @Column(name = "nombre_usuario", length = 50, nullable = false)
    private String username;

    @Column(name = "clave_encriptada", length = 32, nullable = false)
    private String encryptedPassword;

    @Column(name = "tipo_usuario", nullable = false)
    private String userType;

    @Column(name = "habilitado", nullable = false)
    private boolean enabled;

    @Column(name = "logueado", nullable = false)
    private boolean loggedIn;

    @Column(name = "fecha_creacion", nullable = false)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "fecha_modificacion")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("email", email)
                .append("username", username)
                .append("encryptedPassword", encryptedPassword)
                .append("userType", userType)
                .append("enabled", enabled)
                .append("loggedIn", loggedIn)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .toString();
    }
}