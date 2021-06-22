package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class OrganizationException extends BusinessException implements Supplier<OrganizationException> {
    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "organization.request.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public OrganizationException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static OrganizationException notFound(Long id) {
        return new OrganizationException(NOT_FOUND, "Organización con id " + id + " no encontrada");
    }

    public static OrganizationException notFoundByUserId(Long userId) {
        return new OrganizationException(NOT_FOUND, "Organización con userId " + userId + " no encontrada");
    }

    @Override
    public OrganizationException get() {
        return null;
    }
}
