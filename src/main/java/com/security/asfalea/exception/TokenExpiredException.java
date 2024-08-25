package com.security.asfalea.exception;
/*
 * @author Naveen K Wodeyar
 * @date 25-08-2024
 */

public class TokenExpiredException extends RuntimeException {
    public TokenExpiredException(String message) {
        super(message);
    }
}