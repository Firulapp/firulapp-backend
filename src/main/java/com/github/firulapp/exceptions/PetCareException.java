package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class PetCareException extends BusinessException implements Supplier<PetCareException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "pet.care.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public PetCareException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Pet Care Not Found Exception
     *
     * @param id Pet Care id
     * @return PetCareException
     */
    public static PetCareException notFound(Long id) {
        return new PetCareException(NOT_FOUND, "Recomendación de cuidado con id " + id + " no encontrada");
    }

    @Override
    public PetCareException get() {
        return null;
    }
}
