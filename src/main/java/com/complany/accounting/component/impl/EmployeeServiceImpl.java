package com.complany.accounting.component.impl;

import com.complany.accounting.component.EmployeeRepository;
import com.complany.accounting.component.EmployeeService;
import com.complany.accounting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setId(repository.getSize() + 1L);
        repository.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (id != null) {
            employee.setId(id);
            return repository.set(employee);
        }
        return null;
    }

    @Override
    public Employee getEmployee(Long id) {
        return repository.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.getAll();
    }
}
