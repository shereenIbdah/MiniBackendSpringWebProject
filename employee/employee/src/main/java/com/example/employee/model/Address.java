package com.example.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "address")
@Builder
@Getter
@Setter
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
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}
