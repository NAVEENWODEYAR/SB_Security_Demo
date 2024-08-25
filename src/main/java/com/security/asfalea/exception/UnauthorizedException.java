package com.security.asfalea.exception;
/*
 * @author Naveen K Wodeyar
 * @date 25-08-2024
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}