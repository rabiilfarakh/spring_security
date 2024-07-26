package com.example.spring_security.repository;

import com.example.spring_security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
    Optional<Employee> findById(Long id);
}
