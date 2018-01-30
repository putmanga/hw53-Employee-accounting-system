package com.complany.accounting.component;

import com.complany.accounting.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    Employee getEmployee(Long id);
    List<Employee> getAllEmployees();
}
