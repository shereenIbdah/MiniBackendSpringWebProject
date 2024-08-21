package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.gender = ?1")
    List<Employee> findEmployeeByGender(String gender);

    @Query("SELECT e FROM Employee  e WHERE e.age >= ?1 AND e.age <= ?2")
    List<Employee> findEmployeeByAgeRange(int minAge, int maxAge);

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    //findManagers
    @Query("SELECT e FROM Employee e WHERE e.id IN :ids")
    List<Employee> findManagers(@Param("ids") List<Long> ids);


}
