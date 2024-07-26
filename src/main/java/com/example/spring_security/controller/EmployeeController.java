package com.example.spring_security.controller;

import com.example.spring_security.dto.EmployeeDTO;
import com.example.spring_security.entity.Employee;
import com.example.spring_security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String encodedPassword = passwordEncoder.encode(employeeDTO.getPassword());

        Employee employee = new Employee(
                null, // id est généré automatiquement
                employeeDTO.getUsername(),
                employeeDTO.getEmail(),
                encodedPassword,
                employeeDTO.getRole()
        );

        employeeService.saveEmployee(employee);
    }

    @GetMapping("/{username}")
    public Employee getEmployee(@PathVariable String username) {
        return employeeService.findByUsername(username);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee != null) {
            employee.setId(id);
            return employeeService.saveEmployee(employee);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            employeeService.delete(employee);
        }
    }
}
