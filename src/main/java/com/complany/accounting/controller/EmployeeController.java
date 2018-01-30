package com.complany.accounting.controller;

import com.complany.accounting.component.EmployeeService;
import com.complany.accounting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping(value = "/")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @GetMapping(value = "/")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return service.getEmployee(id);
    }
}
