package com.example.employee.dto;

import com.example.employee.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Builder
@AllArgsConstructor
public class EmployeeV2DTO {
    private Long id;
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
    private String email;
    private Long departmentId;
    private static final double ANNUAL_INCREMENT = 200;
    private static final double ANNUAL_BONUS_RATE = 0.05;

    public EmployeeV2DTO(Long id, String name, Integer age, Integer phoneNumber,
                         String gender, Double baseSalary, LocalDate hireDate,
                         String role, Address address, String email, Long departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.baseSalary = baseSalary;
        this.hireDate = hireDate;
        this.role = role;
        this.address = address;
        this.email = email;
        this.departmentId = departmentId;
    }

    public EmployeeV2DTO( String name, Integer age, Integer phoneNumber,
                         String gender, Double baseSalary, LocalDate hireDate,
                         String role, Address address, String email, Long departmentId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.baseSalary = baseSalary;
        this.hireDate = hireDate;
        this.role = role;
        this.address = address;
        this.email = email;
        this.departmentId = departmentId;
    }

    public EmployeeV2DTO() {
    }

    public double getCurrentSalary() {
        //the hire date(every year before current year equals 200$ + the base salar
        int years = LocalDate.now().getYear() - hireDate.getYear();
        if (years > 0) {
            currentSalary = baseSalary + years * ANNUAL_INCREMENT + years*(baseSalary * ANNUAL_BONUS_RATE);
        } else {
            currentSalary = baseSalary;
        }
        return currentSalary;
    }
}
