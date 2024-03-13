package com.white.course2homework11.service;


import com.white.course2homework11.entitys.Employee;
import com.white.course2homework11.enums.Department;
import com.white.course2homework11.exceptions.ArrayIsFull;
import com.white.course2homework11.exceptions.EmployeeAlreadyAdded;
import com.white.course2homework11.repository.EmployeeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl repository;


    @Override
    public Employee add(String name, String surName, String patronymic, Department department, double salary) {
        Employee employee = new Employee(name, surName, patronymic, department, salary);
        if (!repository.isNotFullDb()) throw new ArrayIsFull();
        if (repository.contains(employee)) throw new EmployeeAlreadyAdded();
        repository.add(employee);
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = findById(id);
        repository.delete(employee);
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
