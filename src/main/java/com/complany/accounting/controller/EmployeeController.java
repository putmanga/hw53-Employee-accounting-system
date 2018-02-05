package com.complany.accounting.controller;

import com.complany.accounting.exception.InputValidationException;
import com.complany.accounting.model.EmployeeSaveEntity;
import com.complany.accounting.model.EmployeeUpdateEntity;
import com.complany.accounting.service.EmployeeService;
import com.complany.accounting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping(value = "/")
    public Employee save(@Valid @RequestBody EmployeeSaveEntity employeeSaveEntity,
                         BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return service.save(employeeSaveEntity);
    }

    @PutMapping(value = "/{id}")
    public Employee update(@PathVariable("id") Long id,
                           @Valid @RequestBody EmployeeUpdateEntity employeeUpdateEntity,
                           BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return service.update(id, employeeUpdateEntity);
    }

    @GetMapping(value = "/")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Employee get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PutMapping(value = "/{id}/promote")
    public Employee promote(@PathVariable Long id) {
        return service.promote(id);
    }

    @PutMapping(value = "/{id}/demote")
    public Employee demote(@PathVariable Long id) {
        return service.demote(id);
    }

    @PutMapping(value = "/{id}/hire")
    public Employee hire(@PathVariable Long id) {
        return service.hire(id);
    }

    @PutMapping(value = "/{id}/fire")
    public Employee fire(@PathVariable Long id) {
        return service.fire(id);
    }
}
