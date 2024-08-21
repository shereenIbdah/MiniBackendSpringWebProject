package com.example.department.service;

import com.example.department.client.EmployeeClient;
import com.example.department.model.Department;
import com.example.department.model.Employee;
import com.example.department.model.FullEmployeeResponse;
import com.example.department.model.FullManagersResponse;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.example.department.model.ManagerIdProjection;


import java.util.List;
@Service

public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;
   @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }


    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) {
            throw new IllegalStateException("department with id " + departmentId + " does not exists");
        }
        departmentRepository.deleteById(departmentId);
    }

    public void updateDepartment(Long departmentId, String name) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "department with id " + departmentId + " does not exists"
                ));
        if (name != null) {
            department.setName(name);
        }
        departmentRepository.save(department);
    }
    public FullEmployeeResponse findEmployeesInDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "department with id " + departmentId + " does not exists"
                ));
        var employees = employeeClient.getEmployeesInDepartment(departmentId);
        return FullEmployeeResponse.builder()
                .name(department.getName())
                .employeeList(employees)
                .build();

    }

    public FullManagersResponse getManagers() {
        List<Long> getManagerIds = departmentRepository.findManagerIds().stream()
                    .map(ManagerIdProjection::getManagerId)
                    .toList();
        List<Employee> managers = employeeClient.getManagers(getManagerIds);
        return FullManagersResponse.builder()
                .managerList(managers)
                .build();
    }

}
