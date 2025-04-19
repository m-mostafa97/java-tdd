package com.khalifa.tdd.controller;

import org.springframework.web.bind.annotation.RestController;

import com.khalifa.tdd.model.Task;
import com.khalifa.tdd.service.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
}