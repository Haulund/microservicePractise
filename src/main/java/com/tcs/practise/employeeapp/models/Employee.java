package com.tcs.practise.employeeapp.models;

import com.tcs.practise.employeeapp.EmployeeAppApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Employee
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    private int age;

    public Employee (String name, String department, int age) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Employee (Employee emp) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.age = emp.getAge();
        this.department = emp.getDepartment();
    }
}