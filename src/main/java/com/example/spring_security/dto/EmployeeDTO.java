package com.example.spring_security.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String username;
    private String email;
    private String password;
    private String role;
}
