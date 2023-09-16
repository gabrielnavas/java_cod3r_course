package com.navas.campominado.exceptions;

public class ExplosaoException extends RuntimeException {
    public ExplosaoException(String message) {
        super(message, new Exception(message));
    }
}
