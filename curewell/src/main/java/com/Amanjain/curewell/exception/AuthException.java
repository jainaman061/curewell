package com.Amanjain.curewell.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class AuthException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public AuthException(HttpStatus status, String message) {
        this.message = message;
        this.status = status;

    }

}
