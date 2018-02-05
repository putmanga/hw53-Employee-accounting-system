package com.complany.accounting.exception;

import com.complany.accounting.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputValidationException extends AbstractAPIException {

    private ErrorResponse errorResponse;
    private BindingResult result;

    public InputValidationException(BindingResult result) {
        this.result = result;
    }

    public ErrorResponse getErrorResponse() {
        if (errorResponse == null) {
            errorResponse = new ErrorResponse();
        }

        List<FieldError> fieldErrors = result.getFieldErrors();

        Map<String, List<String>> errors = new HashMap<>();

        for (FieldError fieldError : fieldErrors) {
            errors.putIfAbsent(fieldError.getField(), new ArrayList<>());
            errors.get(fieldError.getField()).add(fieldError.getDefaultMessage());
        }

        errorResponse.setErrors(errors);

        return errorResponse;
    }

    public HttpStatus getHttpStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
