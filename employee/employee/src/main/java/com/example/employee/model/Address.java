package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "address")
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    //address has many employees
    // name must be the same as the field in the Employee class
    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Employee> employees;


    public Address() {
    }

    public Address(Long id, String location, List<Employee> employees) {
        this.id = id;
        this.location = location;
        this.employees = employees;
    }
    public Address(Long id, String location) {
        this.id = id;
        this.location = location;
    }


    public Address(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
