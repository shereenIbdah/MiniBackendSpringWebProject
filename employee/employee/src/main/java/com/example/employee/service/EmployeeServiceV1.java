package com.example.employee.service;

import com.example.employee.dto.EmployeeV1DTO;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceV1 {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceV1(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(EmployeeV1DTO employeeDTO) {
        // map the employee dto to employee entity
        Employee employee = new Employee(
                employeeDTO.getName(),
                employeeDTO.getAge(),
                employeeDTO.getPhoneNumber(),
                employeeDTO.getGender(),
                employeeDTO.getBaseSalary(),
                employeeDTO.getHireDate(),
                employeeDTO.getRole(),
                employeeDTO.getAddress(),
                employeeDTO.getDepartmentId()
        );
        employeeRepository.save(employee);
    }

    public List<EmployeeV1DTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        // map the employee entity to employee dto
        return employees.stream()
                .map(employee -> new EmployeeV1DTO(
                        employee.getId(),
                        employee.getName(),
                        employee.getAge(),
                        employee.getPhoneNumber(),
                        employee.getGender(),
                        employee.getBaseSalary(),
                        employee.getRole(),
                        employee.getAddress(),
                        employee.getHireDate(),
                        employee.getDepartmentId()
                ))
                .collect(Collectors.toList());

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
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<Employee> getEmployeesBasedOnGender(String gender) {
        return employeeRepository.findEmployeeByGender(gender);

    }
    public List<Employee> getEmployeesByAgeRange(int minAge, int maxAge) {
        return employeeRepository.findEmployeeByAgeRange(minAge, maxAge);
    }
    public List<Employee> getEmployeesInDepartment(Long departmentId) {
        return  employeeRepository.findEmployeeByDepartmentId(departmentId);
    }
    public List<Employee> getManagers(List<Long> managerIds) {
        return employeeRepository.findManagers(managerIds);
    }

}
