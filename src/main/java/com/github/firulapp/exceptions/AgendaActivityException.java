package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class AgendaActivityException extends BusinessException implements Supplier<AgendaActivityException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "species.error";

    public AgendaActivityException(String errorCode, String message) {
        super(errorCode, message);
    }

    @Override
    public AgendaActivityException get() {
        return null;
    }
}
