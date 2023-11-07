package com.provateTecnica.Api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErroException> handleException(Exception e) {
        ApiErroException apiErro = new ApiErroException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiErroException> handleCustomExeption(CustomException e) {
        ApiErroException apiErro = new ApiErroException(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(apiErro, apiErro.getStatus());
    }
}
