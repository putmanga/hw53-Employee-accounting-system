package com.complany.accounting.model;

import com.complany.accounting.enums.EmployeeStatus;
import com.complany.accounting.enums.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20")
    private String lastName;

    private EmployeeType employeeType;

    private EmployeeStatus employeeStatus;

    public static Employee initFromSaveEntity(EmployeeSaveEntity employeeSaveEntity) {
        Employee employee = new Employee();

        employee.setFirstName(employeeSaveEntity.getFirstName());
        employee.setLastName(employeeSaveEntity.getLastName());
        employee.setEmployeeType(employeeSaveEntity.getEmployeeType());

        return employee;
    }
}
