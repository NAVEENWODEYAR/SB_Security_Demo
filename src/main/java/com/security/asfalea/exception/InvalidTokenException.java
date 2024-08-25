package com.security.asfalea.exception;
/*
 * @author Naveen K Wodeyar
 * @date 25-08-2024
 */

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }
}