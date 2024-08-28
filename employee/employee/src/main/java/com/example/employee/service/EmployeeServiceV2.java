package com.example.employee.service;

import com.example.employee.dto.EmployeeV2DTO;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceV2 {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceV2(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(EmployeeV2DTO employeedto) {
        Employee employee = new Employee();
        employee.setName(employeedto.getName());
        employee.setAge(employeedto.getAge());
        employee.setPhoneNumber(employeedto.getPhoneNumber());
        employee.setGender(employeedto.getGender());
        employee.setBaseSalary(employeedto.getBaseSalary());
        employee.setRole(employeedto.getRole());
        employee.setHireDate(employeedto.getHireDate());
        employee.setAddress(employeedto.getAddress());
        employee.setDepartmentId(employeedto.getDepartmentId());
        employee.setEmail(employeedto.getEmail());
        employeeRepository.save(employee);
    }

    public List<EmployeeV2DTO> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> new EmployeeV2DTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getAge(),
                        employee.getPhoneNumber(),
                        employee.getGender(),
                        employee.getBaseSalary(),
                        employee.getHireDate(),
                        employee.getRole(),
                        employee.getAddress(),
                        employee.getEmail(),
                        employee.getDepartmentId()
                ))
                .collect(java.util.stream.Collectors.toList());
    }


    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("employee with id " + employeeId + " does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }


    public void updateEmployee(Long employeeId, String name, String gender, Integer age,
                               Integer phoneNumber, Double baseSalary, String role) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "employee with id " + employeeId + " does not exists"
                ));
        if (name != null) {
            employee.setName(name);
        }
        if (gender != null) {
            employee.setGender(gender);
        }
        if (age != null) {
            employee.setAge(age);
        }
        if (phoneNumber != null) {
            employee.setPhoneNumber(phoneNumber);
        }
        if (baseSalary != null) {
            employee.setBaseSalary(baseSalary);
        }

        if (role != null) {
            employee.setRole(role);
        }
        employeeRepository.save(employee);

    }

    public List<Employee> getEmployeesWithPagination(int page, int pageSize) {
        if (pageSize == -1) {
            return employeeRepository.findAll();
        } else {
            Page<Employee> employees = employeeRepository.findAll(PageRequest.of(page, pageSize));
            return employees.getContent();
        }
    }

    public List<Employee> getEmployeeSortedByName() {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return employees;
    }

    public List<Employee> getEmployessBasedOnGender(String gender) {
        List<Employee> employees = employeeRepository.findEmployeeByGender(gender);
        return employees;

    }
    public List<Employee> getEmployeesByAgeRange(int minAge, int maxAge) {
        List<Employee> employees = employeeRepository.findEmployeeByAgeRange(minAge, maxAge);
        return employees;
    }
    public List<Employee> getEmployessInDepartment(Long departmentId) {
        List<Employee> employees = employeeRepository.findEmployeeByDepartmentId(departmentId);
        return employees;
    }
    public List<Employee> getManagers(List<Long> managerIds) {
        List<Employee> employees = employeeRepository.findManagers(managerIds);
        return employees;
    }

}
