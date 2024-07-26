package com.example.spring_security.service;

import com.example.spring_security.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee findByUsername(String username);
    Employee findById(Long id);
    void delete(Employee employee);
}
