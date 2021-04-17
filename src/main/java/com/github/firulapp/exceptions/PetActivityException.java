package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class PetActivityException extends BusinessException implements Supplier<PetActivityException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "pet.activity.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String MISSING_DATA= BASE_ERROR + ".data.missing";

    public PetActivityException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a PetActivityException Not Found Exception
     *
     * @param id PetActivity id
     * @return PetActivityException
     */
    public static PetActivityException notFound(Long id) {
        return new PetActivityException(NOT_FOUND, "No se encontró la ficha médica con id" + id);
    }

    public static PetActivityException missingData(){
        return new PetActivityException(MISSING_DATA, "No se pudo realizar la operación. Los datos son erroneos o incompletos");
    }

    @Override
    public PetActivityException get() {
        return null;
    }
}
