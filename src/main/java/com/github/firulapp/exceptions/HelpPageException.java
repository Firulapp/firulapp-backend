package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class HelpPageException extends BusinessException implements Supplier<HelpPageException>{

        private static final long serialVersionUID = 1L;
        public static final String BASE_ERROR = "helpPage.error";
        public static final String NOT_FOUND = BASE_ERROR + ".notFound";

    public HelpPageException(String errorCode, String message) {
        super(errorCode, message);
    }

        /**
         * Builds a Help Page Not Found Exception
         *
         * @param id Help Page id
         * @return HelpPageException
         */
        public static HelpPageException notFound(Long id) {
        return new HelpPageException(NOT_FOUND, String.format("Página de ayuda con id %n no encontrado" , id));
    }

        @Override
        public HelpPageException get() {
        return null;
    }
}