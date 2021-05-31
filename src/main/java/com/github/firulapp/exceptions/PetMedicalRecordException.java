package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class PetMedicalRecordException extends BusinessException implements Supplier<PetMedicalRecordException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "pet.medical.record.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String MISSING_DATA= BASE_ERROR + ".data.missing";

    public PetMedicalRecordException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a PetMedicalRecord Not Found Exception
     *
     * @param id PetMedicalRecord id
     * @return PetException
     */
    public static PetMedicalRecordException notFound(Long id) {
        return new PetMedicalRecordException(NOT_FOUND, "No se encontró la ficha médica con id" + id);
    }

    public static PetMedicalRecordException missingData(){
        return new PetMedicalRecordException(MISSING_DATA, "No se pudo realizar la operación. Los datos son erroneos o incompletos");
    }
    @Override
    public PetMedicalRecordException get() {
        return null;
    }
}
