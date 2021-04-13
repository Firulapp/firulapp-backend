package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class ConductRuleException extends BusinessException implements Supplier<ConductRuleException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "conductRules.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public ConductRuleException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a Conduct Rule Not Found Exception
     *
     * @param id Breed id
     * @return ConductRuleException
     */
    public static ConductRuleException notFound(Long id) {
        return new ConductRuleException(NOT_FOUND, "Regla de conducta con id " + id + " no encontrada");
    }

    @Override
    public ConductRuleException get() {
        return null;
    }
}
