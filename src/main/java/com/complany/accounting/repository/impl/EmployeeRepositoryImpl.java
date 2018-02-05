package com.complany.accounting.repository.impl;

import com.complany.accounting.model.Employee;
import com.complany.accounting.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private Path storagePath;

    public EmployeeRepositoryImpl() {
        getStoragePath();
    }

    @SneakyThrows
    private void getStoragePath() {
        Properties properties = new Properties();
        InputStream is = EmployeeRepositoryImpl.class.getResourceAsStream("/application.properties");
        properties.load(is);

        storagePath = Paths.get(properties.getProperty("storage.path"));
    }

    private List<Employee> getList() {
        List<Employee> employees;
        try {
            employees = objectMapper.readValue(storagePath.toFile(), new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            employees = new ArrayList<>();
        }

        return employees;
    }

    @SneakyThrows
    private void saveList(List<Employee> employees) {
        objectMapper.writeValue(storagePath.toFile(), employees);
    }

    @Override
    public void save(Employee employee) {
        List<Employee> employees = getList();
        employees.add(employee);
        saveList(employees);
    }

    @Override
    public Employee update(Employee employee) {
        List<Employee> employees = getList();
        Long id = employee.getId();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, employee);
                saveList(employees);
                return employee;
            }
        }

        return null;
    }

    @Override
    public Employee get(Long id) {
        List<Employee> employees = getList();
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return getList();
    }
}
