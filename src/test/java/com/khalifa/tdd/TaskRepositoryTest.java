package com.khalifa.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.khalifa.tdd.model.Task;
import com.khalifa.tdd.repository.TaskRepository;

@DataJpaTest
public class TaskRepositoryTest {
    
    @Autowired
    TaskRepository taskRepository;
    @Test
    void saveTaskTest() {
        Task task = Task.builder().title("Test save test").status("TODO").build();

        Task savedTask = taskRepository.save(task);
        assertNotNull(savedTask);
        assertEquals(task.getTitle(), savedTask.getTitle());
    }
}