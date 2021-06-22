package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class OrganizationRequestException extends BusinessException implements Supplier<OrganizationRequestException> {
    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "organization.request.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String MISSING_DATA = BASE_ERROR + "missing.data";

    public OrganizationRequestException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static OrganizationRequestException notFound(Long id) {
        return new OrganizationRequestException(NOT_FOUND, "Solicitud con id " + id + " no encontrada");
    }
    public static OrganizationRequestException missingData(){
        return new OrganizationRequestException(MISSING_DATA, "No se pudo crear la solicitud");
    }

    @Override
    public OrganizationRequestException get() {
        return null;
    }
}
