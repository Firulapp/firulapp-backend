package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class ServiceTypeException extends BusinessException implements Supplier<ServiceTypeException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "service.type.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public ServiceTypeException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Service Type Not Found Exception
     *
     * @param id Service type id
     * @return ServiceTypeException
     */
    public static ServiceTypeException notFound(Long id) {
        return new ServiceTypeException(NOT_FOUND, String.format("Tipo de servicio con id %n no encontrado" , id));
    }

    @Override
    public ServiceTypeException get() {
        return null;
    }
}