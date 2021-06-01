package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class ReportPetException extends BusinessException implements Supplier<ReportPetException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "report.pet.record.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String MISSING_DATA= BASE_ERROR + ".data.missing";

    public ReportPetException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static ReportPetException notFound(Long id) {
        return new ReportPetException(NOT_FOUND, "No se encontró el reporte con id" + id);
    }

    public static ReportPetException missingData(){
        return new ReportPetException(MISSING_DATA, "No se pudo realizar la operación. Los datos son erroneos o incompletos");
    }
    @Override
    public ReportPetException get() {
        return null;
    }
}
