package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class CityException extends BusinessException implements Supplier<CityException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "city.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String DUPLICATED_ENTRY = BASE_ERROR + ".duplicated";

    public CityException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a City Not Found Exception
     *
     * @param id Breed id
     * @return BreedException
     */
    public static CityException notFound(Long id) {
        return new CityException(NOT_FOUND, "Ciudad con id " + id + " no encontrado");
    }

    public static CityException duplicatedEntry(String city, String country){
        return new CityException(DUPLICATED_ENTRY, "Ciudad "+ city + " en pais "+ country + " ya existe");
    }

    @Override
    public CityException get() {
        return null;
    }
}
