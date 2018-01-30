package com.complany.accounting.model;

import com.complany.accounting.enums.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private EmployeeType employeeType;
}
