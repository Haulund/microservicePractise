package com.tcs.practise.employeeapp.models;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task extends RepresentationModel<Task>{
    @Id
    @GeneratedValue
    private Long taskId;
    private String taskDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Employee employee;

    public Task(Task task){
        this.taskId = task.getTaskId();
        this.taskDescription = task.getTaskDescription();
    }
}
