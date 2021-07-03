package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class ServiceEntityException extends BusinessException implements Supplier<ServiceEntityException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "service.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public ServiceEntityException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Service Not Found Exception
     *
     * @param id Service id
     * @return ServiceEntityException
     */
    public static ServiceEntityException notFound(Long id) {
        return new ServiceEntityException(NOT_FOUND, "Servicio con id " + id + " no encontrado");
    }

    @Override
    public ServiceEntityException get() {
        return null;
    }
}