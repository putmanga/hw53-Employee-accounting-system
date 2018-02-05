package com.complany.accounting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeUpdateEntity {

    @Length(min = 3, max = 20, message = "Length must be between 3 and 20")
    private String firstName;

    @Length(min = 3, max = 20, message = "Length must be between 3 and 20")
    private String lastName;
}
