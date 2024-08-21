package com.example.department.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer age;
    private Integer phoneNumber;
    private String gender;
    private Double baseSalary;
    private Double currentSalary;
    private LocalDate hireDate;
    private String role;
    //employee has one address (join in the many side)
    private Address address;

    private Long departmentId;
}
