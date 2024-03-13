package com.white.course2homework11.service;


import com.white.course2homework11.entitys.Employee;
import com.white.course2homework11.enums.Department;

import java.util.List;


public interface EmployeeService {
    Employee add(String name, String surName, String patronymic, Department department, double salary);

    void deleteById(Long id);

    Employee findById(Long id);

    List<Employee> findAll();
}
