package com.khalifa.tdd.controller;

import org.springframework.web.bind.annotation.RestController;

import com.khalifa.tdd.model.Task;
import com.khalifa.tdd.service.TaskService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @PostMapping("/tasks")
    public Task saveTask(@RequestBody Task task) {
        log.info("Saving task: {}", task);
        return taskService.saveTask(task);
    }

    @GetMapping("/tasks/delete")
    public List<Task> deleteList() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/update")
    public String updateList() {
        return "Update task";
    }
}