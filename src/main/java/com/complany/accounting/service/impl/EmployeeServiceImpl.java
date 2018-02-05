package com.complany.accounting.service.impl;

import com.complany.accounting.enums.EmployeeStatus;
import com.complany.accounting.exception.EmployeeStatusMismatchException;
import com.complany.accounting.model.EmployeeSaveEntity;
import com.complany.accounting.model.EmployeeUpdateEntity;
import com.complany.accounting.repository.EmployeeRepository;
import com.complany.accounting.service.EmployeeService;
import com.complany.accounting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee save(EmployeeSaveEntity employeeSaveEntity) {

        Employee employee = Employee.initFromSaveEntity(employeeSaveEntity);

        employee.setId(repository.getAll().size() + 1L);
        employee.setEmployeeStatus(EmployeeStatus.CANDIDATE);

        repository.save(employee);

        return employee;
    }

    @Override
    public Employee update(Long id, EmployeeUpdateEntity employeeUpdateEntity) {
        if (id != null) {
            Employee employee = get(id);
            if (employeeUpdateEntity.getFirstName() != null) {
                employee.setFirstName(employeeUpdateEntity.getFirstName());
            }
            if (employeeUpdateEntity.getLastName() != null) {
                employee.setLastName(employeeUpdateEntity.getLastName());
            }
            return repository.update(employee);
        }
        return null;
    }

    @Override
    public Employee get(Long id) {
        return repository.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Employee promote(Long id) {
        Employee employee = get(id);
        if (employee.getEmployeeStatus() == EmployeeStatus.HIRED) {
            employee.setEmployeeType(employee.getEmployeeType().getNext());
            repository.update(employee);
            return employee;
        } else {
            throw new EmployeeStatusMismatchException(employee.getEmployeeStatus());
        }
    }

    @Override
    public Employee demote(Long id) {
        Employee employee = get(id);
        if (employee.getEmployeeStatus() == EmployeeStatus.HIRED) {
            employee.setEmployeeType(employee.getEmployeeType().getPrev());
            repository.update(employee);
            return employee;
        } else {
            throw new EmployeeStatusMismatchException(employee.getEmployeeStatus());
        }
    }

    @Override
    public Employee hire(Long id) {
        Employee employee = get(id);
        if (employee.getEmployeeStatus() != EmployeeStatus.HIRED) {
            employee.setEmployeeStatus(EmployeeStatus.HIRED);
            repository.update(employee);
            return employee;
        } else {
            throw new EmployeeStatusMismatchException(employee.getEmployeeStatus());
        }
    }

    @Override
    public Employee fire(Long id) {
        Employee employee = get(id);
        if (employee.getEmployeeStatus() != EmployeeStatus.FIRED) {
            employee.setEmployeeStatus(EmployeeStatus.FIRED);
            repository.update(employee);
            return employee;
        } else {
            throw new EmployeeStatusMismatchException(employee.getEmployeeStatus());
        }
    }
}
