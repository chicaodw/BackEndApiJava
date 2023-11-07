package com.provateTecnica.Api.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiErroException {
    private HttpStatus status;
    private String message;

    public ApiErroException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
