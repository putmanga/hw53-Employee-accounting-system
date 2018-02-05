package com.complany.accounting.exception;

import com.complany.accounting.model.ErrorResponse;
import org.springframework.http.HttpStatus;

public abstract class AbstractAPIException extends RuntimeException {

    public abstract ErrorResponse getErrorResponse();

    public abstract HttpStatus getHttpStatusCode();
}
