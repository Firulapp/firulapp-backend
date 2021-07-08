package com.github.firulapp.exceptions;

public class AppUserException extends BusinessException{

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "appUser.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String EMAIL_REGISTERED = BASE_ERROR + ".emailAlreadyExists";
    public static final String USERNAME_REGISTERED = BASE_ERROR + ".usernameAlreadyExists";
    public static final String PASSWORDS_DONT_MATCH = BASE_ERROR + ".passwordsDontMatch";
    public static final String MISSING_DATA = BASE_ERROR + ".missing.data";
    public static final String USER_NOT_ALLOWED = BASE_ERROR + ".user.notEnabled";

    public AppUserException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a User Not Found Exception
     *
     * @param usernameOrEmail username or id not found
     * @return AppUserException
     */
    public static AppUserException notFound(String usernameOrEmail) {
        return new AppUserException(NOT_FOUND, "AppUser " + usernameOrEmail + " no encontrado");
    }

    public static AppUserException emailRegistered(String email) {
        return new AppUserException(EMAIL_REGISTERED, "El email " + email + " ya está registrado en la aplicación");
    }

    public static AppUserException usernameRegistered(String username) {
        return new AppUserException(USERNAME_REGISTERED, "El nombre de usuario " + username + " ya existe");
    }
    public static AppUserException passwordDoNotMatch() {
        return new AppUserException(PASSWORDS_DONT_MATCH, "Las contraseñas no coinciden");
    }
    public static AppUserException missingData() {
        return new AppUserException(MISSING_DATA,"Faltan datos para realizar la accion");
    }
    public static AppUserException userNotAllowed(String email){
        return new AppUserException(USER_NOT_ALLOWED, "El usuario con mail "+ email + " no está habilitado");
    }
}

