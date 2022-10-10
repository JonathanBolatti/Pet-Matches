package com.petmatches.users.exception;


import java.io.Serial;

public class AuthenticationException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 3637691580849407032L;

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

}
