package com.khalifa.tdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khalifa.tdd.model.Task;
import com.khalifa.tdd.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    public Task updateTaskStatus(Long id, String status) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task updatedTask = task.get();
            updatedTask.setStatus(status);
            return taskRepository.save(updatedTask);
        }
        return null;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}