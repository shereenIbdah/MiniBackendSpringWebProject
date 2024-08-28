package com.example.employee.dto;

import com.example.employee.model.Address;
import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
public class EmployeeV1DTO {
    private Long id;
    private String name;
    private Integer age;
    private Integer phoneNumber;
    private String gender;
    private Double baseSalary;
    private Double currentSalary;
    private LocalDate hireDate;
    private String role;
    private Address address;
    private Long departmentId;
    private static final double ANNUAL_INCREMENT = 200;

    public EmployeeV1DTO( String name, Integer age, Integer phoneNumber,
                         String gender, Double baseSalary, String role,
                         Address address, LocalDate hireDate , Long departmentId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.baseSalary = baseSalary;
        this.role = role;
        this.address = address;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }
    public EmployeeV1DTO(Long id, String name, Integer age, Integer phoneNumber,
                          String gender, Double baseSalary, String role,
                          Address address, LocalDate hireDate , Long departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.baseSalary = baseSalary;
        this.role = role;
        this.address = address;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }

    public double getCurrentSalary() {
        int years = LocalDate.now().getYear() - hireDate.getYear();
        if (years > 0) {
            currentSalary = baseSalary + years * ANNUAL_INCREMENT;
        } else {
            currentSalary = baseSalary;
        }
        return currentSalary;
    }
}
