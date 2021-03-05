package com.github.firulapp.exceptions;

import com.github.firulapp.constants.FieldPossibleErrors;

/**
 * Indica que es un error de logica de negocios. No corresponde a un fallo del
 * sistema sino a un problema en el procesamiento. en general debería ser
 * ocasionado por un dato mal proporcionado
 *
 * @author danicricco
 */
public abstract class BusinessException extends Exception {

    private static final long serialVersionUID = 8943855572101122016L;

    private String errorCode;

    protected String offendingField;
    protected FieldPossibleErrors fieldErrorType;

    protected BusinessException(String errorCode, String message) {
        this(null, errorCode, message);
        this.offendingField = null;
        this.fieldErrorType = null;

    }

    protected BusinessException(Throwable pCause, String pErrorCode, String pMessage) {
        super(pMessage, pCause);
        setErrorCode(pErrorCode);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String pErrorCode) {
        errorCode = pErrorCode;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message != null) {
            return message;
        }
        return null;
    }

}
