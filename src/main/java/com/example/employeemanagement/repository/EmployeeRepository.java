package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee>findAll();

   Optional<Employee> findById(String id);

    @Query("{name:'?0'}")
   List <Employee> findEmployeeByName(String name);

    @Query(value = "{jobDescription:'?0'}")
    List<Employee> findAllByJobDescription(String jobDescription);

}
