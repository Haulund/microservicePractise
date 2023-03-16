package com.tcs.practise.employeeapp.models;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



/**
 * Employee
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends RepresentationModel<Employee>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmployeeId;
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
        this.EmployeeId = emp.getEmployeeId();
        this.name = emp.getName();
        this.age = emp.getAge();
        this.department = emp.getDepartment();
    }
}