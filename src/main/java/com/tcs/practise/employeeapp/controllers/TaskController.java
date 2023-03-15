package com.tcs.practise.employeeapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.practise.employeeapp.exceptionHandling.EmployeeNotFoundException;
import com.tcs.practise.employeeapp.models.Employee;
import com.tcs.practise.employeeapp.models.Task;
import com.tcs.practise.employeeapp.repositories.EmployeeRepository;
import com.tcs.practise.employeeapp.services.TaskServiceImpl;

@RestController
@RequestMapping(value = "/api/employee/")
public class TaskController {

    @Autowired
    private EmployeeRepository EmployeeRepository;

    @Autowired
    private TaskServiceImpl taskService;
    
    @GetMapping("/{employeeId}/tasks")
    public List<Task> getAllTasks(@PathVariable int employeeId) throws EmployeeNotFoundException{
        Optional<Employee> empOpt = EmployeeRepository.findById(employeeId);
        if(!empOpt.isPresent()){
            throw new EmployeeNotFoundException();
        }
        return empOpt.get().getTasks();
    }

    @PostMapping("/{employeeId}/tasks")
    public Task createOrder(@PathVariable int employeeId, @RequestBody Task task) throws EmployeeNotFoundException {
        Optional<Employee> empOpt = EmployeeRepository.findById(employeeId);
        if(!empOpt.isPresent()){
            throw new EmployeeNotFoundException();
        }
        Employee emp = empOpt.get();
        task.setEmployee(emp);
        return taskService.create(task);
    }

    @GetMapping("/{employeeId}/tasks/{taskId}")
    public Task getTaskByIdController(@PathVariable int employeeId, @PathVariable Long taskId) {
        Optional<Employee> empOpt = EmployeeRepository.findById(employeeId);
        if(!empOpt.isPresent()){
            throw new EmployeeNotFoundException();
        }

        return taskService.getTaskById(taskId);
    }
}
