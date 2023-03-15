package com.tcs.practise.employeeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.practise.employeeapp.exceptionHandling.EmployeeNotFoundException;
import com.tcs.practise.employeeapp.models.Employee;
import com.tcs.practise.employeeapp.services.EmployeeServiceImpl;

/**
 * EmployeeController
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public List<Employee> readAll() {
        return employeeService.readAll();
    }
    
    @GetMapping("/{employeeId}")
    public Employee readOne(@PathVariable int employeeId) {
        return employeeService.readOne(employeeId);
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.create(emp);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {
        Employee updated = employeeService.update(emp);
        if (updated == null) {
            throw new EmployeeNotFoundException();
        }
        return new ResponseEntity<>(updated, HttpStatus.OK); 
    }

    @DeleteMapping("/{employeeId}")
    public void name(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
    }
    
}