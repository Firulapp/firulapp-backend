package com.github.firulapp.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AppUserProfileDto extends AppUserDetailsDto{

    private String username;
    private String email;
    private String encryptedPassword;
    private String confirmPassword;
    private String userType;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("email", email)
                .append("encryptedPassword", encryptedPassword)
                .append("confirmPassword", confirmPassword)
                .append("userType", userType)
                .toString();
    }
}
