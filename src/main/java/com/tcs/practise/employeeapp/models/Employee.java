package com.tcs.practise.employeeapp.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @NotNull
    private String department;
    @NotNull
    private int age;

    @OneToMany(mappedBy="employee")
    private List<Task> tasks;

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