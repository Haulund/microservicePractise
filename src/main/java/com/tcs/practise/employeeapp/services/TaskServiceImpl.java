package com.tcs.practise.employeeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.practise.employeeapp.models.Task;
import com.tcs.practise.employeeapp.repositories.TaskRepository;

@Service
public class TaskServiceImpl {

    @Autowired
    TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);    }
}
