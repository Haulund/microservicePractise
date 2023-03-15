package com.tcs.practise.employeeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.tcs.practise.employeeapp.models.Employee;
import com.tcs.practise.employeeapp.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee update(Employee emp) {
        if (employeeRepository.findById(emp.getId()).isPresent()){
            return employeeRepository.save(emp);
        }
        return null;
    }

    public Employee readOne(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);        
    }

    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    public void delete(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
