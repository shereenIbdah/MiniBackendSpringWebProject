package com.example.department.controller;


import com.example.department.model.Department;
import com.example.department.model.FullEmployeeResponse;
import com.example.department.model.FullManagersResponse;
import com.example.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/department")
@AllArgsConstructor
public class DepartmentController {
    @Autowired
    private final DepartmentService departementService;

    @PostMapping(path = "/addDepartment")
    public void addDepartment(@RequestBody Department departement) {
        departementService.addDepartment(departement);
    }

    @GetMapping("/allDepartment")
    public List<Department> getDepartments() {
        return departementService.getDepartments();
    }

    @DeleteMapping(path = "/deleteDepartment/{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Long departementId) {
        departementService.deleteDepartment(departementId);
    }

    @PutMapping(path = "/updateDepartment/{departmentId}")
    public void updateDepartment(@PathVariable("departmentId") Long departementId,
                                  @RequestParam(required = false) String name) {
        departementService.updateDepartment(departementId, name);
    }
    @GetMapping("/EmployeesInDepartment/{departmentId}")
    public ResponseEntity<FullEmployeeResponse> getEmployeesInDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departementService.findEmployeesInDepartment(departmentId));
    }
    // GET ALL MANAGERS OF DEPARTMENTS
    @GetMapping("/departments/managers")
    public  FullManagersResponse getManagers() {
        return departementService.getManagers();
    }
}
