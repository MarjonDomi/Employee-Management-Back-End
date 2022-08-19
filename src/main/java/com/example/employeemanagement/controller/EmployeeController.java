package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.employeemanagement.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        Optional<Employee> optional= employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException("Employee not found for id ::" +id);
        }
       return employee;
    }

    @GetMapping("/name/{name}")
    public List<Employee> getByName(@PathVariable String name){
        return employeeRepository.findEmployeeByName(name);
    }

    @GetMapping("/jobDescription/{jobDescription}")
    public List<Employee> getByJobDescription(@PathVariable String jobDescription) {
        return employeeRepository.findAllByJobDescription(jobDescription);
    }

    @PostMapping("/addnew")
    public String createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return "Employee ADDED " + newEmployee.getName();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable (value = "id") String id,@RequestBody Employee employeeDetails){
       Employee updEmployee = employeeRepository.findById(id).get();
       updEmployee.setId(employeeDetails.getId());
       updEmployee.setName(employeeDetails.getName());
       updEmployee.setSurname(employeeDetails.getSurname());
       updEmployee.setAge(employeeDetails.getAge());
       updEmployee.setJobDescription(employeeDetails.getJobDescription());
       return employeeRepository.save(updEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        Employee delEmployee = employeeRepository.findById(id).get();
        employeeRepository.delete(delEmployee);
        return "deleted succesfully";
    };

}
