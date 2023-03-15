package com.tcs.practise.employeeapp.services;

import com.tcs.practise.employeeapp.models.Task;

public interface TaskService {
    Task create(Task task);
    Task getTaskById(Long taskId);
}
