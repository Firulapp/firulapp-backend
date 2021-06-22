package com.github.firulapp.dto;

public class OrganizationProfileDto {
    AppUserProfileDto profileDto;
    OrganizationDto organizationDto;

    public AppUserProfileDto getProfileDto() {
        return profileDto;
    }

    public void setProfileDto(AppUserProfileDto profileDto) {
        this.profileDto = profileDto;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }
}
