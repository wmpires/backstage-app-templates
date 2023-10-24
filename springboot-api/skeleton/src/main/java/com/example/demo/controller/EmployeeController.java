package com.example.demo.controller;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@ConfiguratorRank
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeController(List<Employee> employees) {
        // Hardcoded fake names and emails
        String[] firstNames = {"John", "Jane", "Bob", "Alice", "Eve", "Michael", "Laura", "David", "Sarah", "Chris"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Brown", "Lee", "Davis", "Taylor", "Wilson", "Evans", "Clark"};

        for (int i = 0; i < 10; i++) {
            String firstname = firstNames[i];
            String lastname = lastNames[i];
            String email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@example.com";

            Employee employee = new Employee(firstname, lastname, email);
            employees.add(employee);
        }
        this.employees = employees;
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Employee{
        private String firstname;
        private String lastname;
        private String email;
    }
}
