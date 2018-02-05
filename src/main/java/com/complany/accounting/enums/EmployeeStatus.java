package com.complany.accounting.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EmployeeStatus {
    CANDIDATE(1),
    HIRED(2),
    FIRED(3);

    private final Integer id;

    @JsonValue
    public Integer getId() {
        return id;
    }

    @JsonCreator
    public static EmployeeStatus getById(Integer id) {
        for (EmployeeStatus status : values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }

        return null;
    }
}
