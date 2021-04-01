package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class BreedException extends BusinessException implements Supplier<BreedException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "breed.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public BreedException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Breed Not Found Exception
     *
     * @param id Breed id
     * @return BreedException
     */
    public static BreedException notFound(Long id) {
        return new BreedException(NOT_FOUND, "Raza con id " + id + " no encontrado");
    }

    @Override
    public BreedException get() {
        return null;
    }
}
