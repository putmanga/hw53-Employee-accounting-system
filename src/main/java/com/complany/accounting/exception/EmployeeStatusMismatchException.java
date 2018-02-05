package com.complany.accounting.exception;

import com.complany.accounting.enums.EmployeeStatus;
import com.complany.accounting.model.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStatusMismatchException extends AbstractAPIException {

    private ErrorResponse errorResponse;
    private EmployeeStatus status;

    public EmployeeStatusMismatchException(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public ErrorResponse getErrorResponse() {

        if (errorResponse == null) {
            errorResponse = new ErrorResponse();
        }

        Map<String, List<String>> errors = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("Operation is not supported for status: " + status.name());

        errors.put("Status", list);

        errorResponse.setErrors(errors);
        return errorResponse;
    }

    @Override
    public HttpStatus getHttpStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
