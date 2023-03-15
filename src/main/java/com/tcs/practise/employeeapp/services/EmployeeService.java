package com.tcs.practise.employeeapp.services;

import java.util.List;

import com.tcs.practise.employeeapp.models.Employee;

public interface EmployeeService {
    Employee create(Employee emp) ;
    Employee update(Employee emp) ;
    Employee readOne(int employeeId) ;
    List<Employee> readAll() ;
    void delete(int employeeId);
}
