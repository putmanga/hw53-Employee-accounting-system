package com.complany.accounting.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum EmployeeType {
    CREW_MEMBER("Crew member", 1),
    TEAM_LEADER("Team leader", 2),
    GROUP_LEADER("Group member", 3),
    PROJECT_MANAGER("Project manager", 4),
    VP_RND("Vice president of R&D", 5),
    VP("Vice president", 6),
    CEO("CEO", 7);

    private final String name;
    private final Integer order;

    EmployeeType(String name, Integer order) {
        this.name = name;
        this.order = order;
    }

    @JsonCreator
    public static EmployeeType fromInt(Integer i) {
        for (EmployeeType type : EmployeeType.values()) {
            if (type.getOrder().equals(i)) {
                return type;
            }
        }

        throw new IllegalArgumentException();
    }
}
