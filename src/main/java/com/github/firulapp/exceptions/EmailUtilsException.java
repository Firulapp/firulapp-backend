package com.github.firulapp.exceptions;

import java.util.function.Supplier;

public class EmailUtilsException extends BusinessException implements Supplier<EmailUtilsException> {

    private static final long serialVersionUID = 1L;
    public static final String BASE_ERROR = "email.utils.error";
    public static final String MESSAGE_CONSTRUCT_ERROR = BASE_ERROR + ".message.build.error";
    public static final String MAIL_SEND_ERROR = BASE_ERROR + ".send.error";

    public EmailUtilsException(String errorCode, String message) {
        super(errorCode, message);
    }

    public static EmailUtilsException messageBuildError(){
        return new EmailUtilsException(MESSAGE_CONSTRUCT_ERROR, "No se pudo construir el mensaje a enviar.");
    }

    public static EmailUtilsException mailSendError(){
        return new EmailUtilsException(MESSAGE_CONSTRUCT_ERROR, "No se pudo enviar el correo construido.");
    }

    @Override
    public EmailUtilsException get() {
        return null;
    }
}
