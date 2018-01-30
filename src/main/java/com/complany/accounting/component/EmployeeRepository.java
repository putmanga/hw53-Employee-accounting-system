package com.complany.accounting.component;

import com.complany.accounting.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    int getSize();
    void add(Employee employee);
    Employee set(Employee employee);
    Employee get(Long id);
    List<Employee> getAll();
}
