package com.complany.accounting.component.impl;

import com.complany.accounting.component.EmployeeRepository;
import com.complany.accounting.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private List<Employee> employees;
    private static ObjectMapper objectMapper = new ObjectMapper();
    private Path storagePath;

    public EmployeeRepositoryImpl() {
        getStoragePath();
        initList();
    }

    @SneakyThrows
    private void getStoragePath() {
        Properties properties = new Properties();
        InputStream is = EmployeeRepositoryImpl.class.getResourceAsStream("/application.properties");
        properties.load(is);

        storagePath = Paths.get(properties.getProperty("storage.path"), properties.getProperty("storage.name"));
    }

    private void initList() {
        try {
            employees = objectMapper.readValue(storagePath.toFile(), new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            employees = new ArrayList<>();
        }
    }

    @Override
    public int getSize() {
        return employees.size();
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee set(Employee employee) {
        Long id = employee.getId();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, employee);
                return employee;
            }
        }

        return null;
    }

    @Override
    public Employee get(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }

    @Override
    protected void finalize() throws Throwable {
        File file = storagePath.toFile();
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
        }
        objectMapper.writeValue(storagePath.toFile(), employees);
    }
}
