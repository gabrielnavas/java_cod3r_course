package com.navas.campominado.exceptions;

public class ExplosaoException extends RuntimeException{
    public ExplosaoException(String message) {
        super(message, new Exception(message));
    }
    public ExplosaoException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
    public ExplosaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
