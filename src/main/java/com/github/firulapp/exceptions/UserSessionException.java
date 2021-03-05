package com.github.firulapp.exceptions;

public class UserSessionException extends BusinessException{

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "userSession.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String SESSION_EXPIRED = BASE_ERROR + ".sessionExpired";

    public UserSessionException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static UserSessionException notFound() {
        return new UserSessionException(NOT_FOUND, String.format("AppUserSession %s no encontrado"));
    }

    public static UserSessionException sessionExpired(String username) {
        return new UserSessionException(SESSION_EXPIRED,
                String.format("La sesión del usuario %s ha expirado", username));
    }

}
