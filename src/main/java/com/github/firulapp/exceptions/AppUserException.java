package com.github.firulapp.exceptions;

public class AppUserException extends BusinessException{

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "appUser.error";
    public static final String NOT_FOUND = BASE_ERROR + ".notFound";
    public static final String EMAIL_REGISTERED = BASE_ERROR + ".emailAlreadyExists";
    public static final String USERNAME_REGISTERED = BASE_ERROR + ".usernameAlreadyExists";
    public static final String PASSWORDS_DONT_MATCH = BASE_ERROR + ".passwordsDontMatch";

    public AppUserException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Builds a User Not Found Exception
     *
     * @param userId User id
     * @return AppUserException
     */
    public static AppUserException notFound(Long userId) {
        return new AppUserException(NOT_FOUND, String.format("AppUser %s no encontrado" , userId));
    }

    public static AppUserException emailRegistered(String email) {
        return new AppUserException(EMAIL_REGISTERED,
                                    String.format("El email %s ya está registrado en la aplicación", email));
    }

    public static AppUserException usernameRegistered(String username) {
        return new AppUserException(USERNAME_REGISTERED,
                                    String.format("El nombre de usuario %s ya existe", username));
    }
    public static AppUserException passwordDoNotMatch() {
        return new AppUserException(PASSWORDS_DONT_MATCH, "Las contraseñas no coinciden");
    }

}

