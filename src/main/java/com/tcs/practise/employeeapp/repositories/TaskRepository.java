package com.tcs.practise.employeeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.practise.employeeapp.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
