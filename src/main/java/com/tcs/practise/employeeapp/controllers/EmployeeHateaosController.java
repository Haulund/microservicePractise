package com.tcs.practise.employeeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.practise.employeeapp.models.Employee;
import com.tcs.practise.employeeapp.services.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/hateoas/employee")
@Validated
public class EmployeeHateaosController{

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public List<Employee> getAllUsers() {
        List<Employee> empList = employeeService.readAll();

        empList.forEach(e -> {
            Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(e.getEmployeeId()).withSelfRel();
            e.add(selfLink);
        
            Link linkToCollection = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(TaskHateaosController.class).getAllTasks(e.getEmployeeId())
            ).withRel("All-tasks");
            e.add(linkToCollection);
        });

        return empList;
    }

    @GetMapping("/{employeeId}")
    public EntityModel<Employee> readOne(@PathVariable int employeeId) {
        Employee emp =  employeeService.readOne(employeeId);
        Link selfLink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(employeeId).withSelfRel();
        emp.add(selfLink);
        EntityModel<Employee> entityModel = EntityModel.of(emp); 
        return entityModel;
    }
}
