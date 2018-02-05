package com.complany.accounting.service;

import com.complany.accounting.model.Employee;
import com.complany.accounting.model.EmployeeSaveEntity;
import com.complany.accounting.model.EmployeeUpdateEntity;

import java.util.List;

public interface EmployeeService {
    Employee save(EmployeeSaveEntity employeeSaveEntity);
    Employee update(Long id, EmployeeUpdateEntity employeeUpdateEntity);
    Employee get(Long id);
    List<Employee> getAll();

    Employee promote(Long id);
    Employee demote(Long id);
    Employee hire(Long id);
    Employee fire(Long id);
}
