package com.complany.accounting.repository;

import com.complany.accounting.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee update(Employee employee);
    Employee get(Long id);
    List<Employee> getAll();
}
