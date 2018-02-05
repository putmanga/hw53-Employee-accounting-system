package com.complany.accounting.controller;

import com.complany.accounting.exception.AbstractAPIException;
import com.complany.accounting.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = AbstractAPIException.class)
    public ResponseEntity<ErrorResponse> getErrorResponse(AbstractAPIException e) {
        return new ResponseEntity<>(e.getErrorResponse(), e.getHttpStatusCode());
    }
}
