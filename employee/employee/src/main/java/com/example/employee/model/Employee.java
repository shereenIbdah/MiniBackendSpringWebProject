package com.example.employee.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getCurrentSalary() {
        //the hire date(every year before current year equals 200$ + the base salar
        int years = LocalDate.now().getYear() - hireDate.getYear();
        if (years > 0) {
            currentSalary = baseSalary + years * 200;
        } else {
            currentSalary = baseSalary;
        }
        return currentSalary;
    }

    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
