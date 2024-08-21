package com.example.department.repository;

import com.example.department.model.Department;
import com.example.department.model.ManagerIdProjection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface DepartmentRepository extends MongoRepository<Department, Long> {
    @Query(value = "{}", fields = "{'managerId': 1, '_id': 0}")
    List<ManagerIdProjection> findManagerIds();

}

