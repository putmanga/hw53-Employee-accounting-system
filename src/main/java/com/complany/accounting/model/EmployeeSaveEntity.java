package com.complany.accounting.model;

import com.complany.accounting.enums.EmployeeType;
import com.complany.accounting.validation.ValidateEnumerationMinMax;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeSaveEntity {

    @NotBlank(message = "First name cannot be blank")
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Length(min = 3, max = 20, message = "Length must be between 3 and 20")
    private String lastName;


//    @ValidateEnumerationMinMax(min = 1, max = 7)
    @ValidateEnumerationMinMax()
    private EmployeeType employeeType;
}
