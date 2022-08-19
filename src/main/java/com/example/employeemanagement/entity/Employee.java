package com.example.employeemanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String jobDescription;

    public Employee() {
        super();
    }

    public Employee(String name, String surname, Integer age, String jobDescription) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }
}

