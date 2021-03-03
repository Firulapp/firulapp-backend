package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class SpeciesException extends BusinessException implements Supplier<SpeciesException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "species.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public SpeciesException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Species Not Found Exception
     *
     * @param id Species id
     * @return SpeciesException
     */
    public static SpeciesException notFound(Long id) {
        return new SpeciesException(NOT_FOUND, String.format("Especies con id %n no encontrado" , id));
    }

    @Override
    public SpeciesException get() {
        return null;
    }
}
