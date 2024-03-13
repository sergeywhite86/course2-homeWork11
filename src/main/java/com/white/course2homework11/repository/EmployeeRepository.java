package com.white.course2homework11.repository;


import com.white.course2homework11.entitys.Employee;

import java.util.List;

public interface EmployeeRepository {

    void add(Employee employee);

    void delete(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    boolean contains(Employee employee);

    boolean isNotFullDb();

}
