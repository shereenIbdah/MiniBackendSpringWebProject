package com.example.department.client;

import com.example.department.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "employee-service", url = "${application.config.employee-url}")
public interface EmployeeClient {
    @GetMapping("/department/{departmentId}")
    List<Employee> getEmployeesInDepartment(@PathVariable Long departmentId);
    @GetMapping("/managers")
    List<Employee> getManagers(@RequestParam  List<Long> managerIds);

}
