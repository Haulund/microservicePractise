package com.tcs.practise.employeeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.practise.employeeapp.models.Employee;
import com.tcs.practise.employeeapp.services.EmployeeServiceImpl;

/**
 * EmployeeController
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/api/employee")
    public List<Employee> readAll() {
        return employeeService.readAll();
    }
    
    @GetMapping("/api/employee/{employeeId}")
    public Employee readOne(@PathVariable int employeeId) {
        return employeeService.readOne(employeeId);
    }

    @PostMapping("/api/employee")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.create(emp);
    }

    @PutMapping("/api/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {
        if (
            Integer.valueOf(emp.getAge()) == null || 
            emp.getDepartment() == null || 
            emp.getName() == null || 
            Integer.valueOf(emp.getId()) == null
            ) {
                throw new TransactionSystemException("any of the fields cannot be Null");
        }
        Employee updated = employeeService.update(emp);
        return new ResponseEntity<>(updated, HttpStatus.OK); 
    }

    @DeleteMapping("/api/employee/{employeeId}")
    public void name(@PathVariable int employeeId) {
        employeeService.delete(employeeId);
    }
    
}