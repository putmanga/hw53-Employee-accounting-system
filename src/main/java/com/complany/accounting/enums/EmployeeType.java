package com.complany.accounting.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EmployeeType {
    CREW_MEMBER(1),
    TEAM_LEADER(2),
    GROUP_LEADER(3),
    PROJECT_MANAGER(4),
    VP_RND(5),
    VP(6),
    CEO(7);

    private final Integer id;

    @JsonValue
    public Integer getId() {
        return id;
    }

    @JsonCreator
    public static EmployeeType getById(Integer id) {
        for (EmployeeType type : values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }

        return null;
    }

    public EmployeeType getNext() {
        Integer nextId = getId() + 1;

        return EmployeeType.getById(nextId);
    }

    public EmployeeType getPrev() {
        Integer nextId = getId() - 1;

        return EmployeeType.getById(nextId);
    }
}
