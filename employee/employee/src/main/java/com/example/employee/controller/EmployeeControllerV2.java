package com.example.employee.controller;
import com.example.employee.dto.EmployeeV2DTO;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v2/employee")
public class EmployeeControllerV2 {
    private final EmployeeServiceV2 employeeService;

    @Autowired
    public EmployeeControllerV2(EmployeeServiceV2 employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/addEmployee")
    public void addEmployee(@RequestBody EmployeeV2DTO employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/allEmployee")
    public List<EmployeeV2DTO> getEmployees() {
        return employeeService.getEmployees();
    }

    @DeleteMapping(path = "/deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String gender,
                               @RequestParam(required = false) Integer age,
                               @RequestParam(required = false) Integer phoneNumber,
                               @RequestParam(required = false) Double baseSalary,
                               @RequestParam(required = false) String role) {
        employeeService.updateEmployee(employeeId, name, gender, age, phoneNumber, baseSalary, role);

    }

    //pagination By page number and size of the page
    @GetMapping("/employees/pagination")
    public List<Employee> getEmployeesWithPagination(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "-1") int pageSize) {
        return employeeService.getEmployeesWithPagination(page, pageSize);
    }

    @GetMapping("/sort/{sort}")
    public List<Employee> getStudentsWithSort(@PathVariable("sort") String name) {
        return employeeService.getEmployeeSortedByName();
    }

    //get employees by gender
    @GetMapping("/gender")
    public List<Employee> getEmployeesByGender(@RequestParam String gender) {
        return employeeService.getEmployeesBasedOnGender(gender);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeesInDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeesInDepartment(departmentId));
    }

    //Get Employees by Age Range:
    @GetMapping("/age")
    public List<Employee> getEmployeesByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return employeeService.getEmployeesByAgeRange(minAge, maxAge);
    }
    @GetMapping("/managers")
    public List<Employee> getManagers(@RequestParam List<Long> managerIds) {
        return employeeService.getManagers(managerIds);
    }


}
