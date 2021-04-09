package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class PetVaccinationRecordException extends BusinessException implements Supplier<PetVaccinationRecordException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "pet.vaccination.record.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String MISSING_DATA= BASE_ERROR + ".data.missing";

    public PetVaccinationRecordException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static PetVaccinationRecordException notFound(Long id){
        return new PetVaccinationRecordException(NOT_FOUND, "No se encontró el registro de vacunación con id "+ id);
    }

    public static PetVaccinationRecordException missingData(){
        return new PetVaccinationRecordException(MISSING_DATA, "No se pudo realizar la operación. Los datos son erroneos o incompletos");
    }
    @Override
    public PetVaccinationRecordException get() {
        return null;
    }
}
