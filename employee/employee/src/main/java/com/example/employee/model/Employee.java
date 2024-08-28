package com.example.employee.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@Setter
@Getter
//@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Integer phoneNumber;
    private String gender;
    private Double baseSalary;
    @Transient
    private Double currentSalary;
    private LocalDate hireDate;
    private String role;
    //employee has one address (join in the many side)
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String email;
    private Long departmentId;
    public Employee() {
    }

    public Employee(String name, Integer age, Integer phoneNumber, String gender, Double baseSalary, LocalDate hireDate, String role, Address address
      , Long departmentId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.baseSalary = baseSalary;
        this.hireDate = hireDate;
        this.role = role;
        this.address = address;
        this.departmentId = departmentId;
    }

    public Employee(String name, Integer age, Integer phoneNumber, String gender,
                    Double baseSalary, LocalDate hireDate,
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

    public Employee(Long id, String name, Integer age, String gender, Integer phoneNumber, Double baseSalary, LocalDate hireDate, String role, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.baseSalary = baseSalary;
        this.hireDate = hireDate;
        this.role = role;
        this.address = address;
//        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", baseSalary=" + baseSalary +
                ", currentSalary=" + currentSalary +
                ", hireDate=" + hireDate +
                ", role='" + role + '\'' +
                ", address=" + address +
                ", departmentId=" + departmentId +
                '}';
    }
}
