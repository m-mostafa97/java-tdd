package com.khalifa.tdd.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.khalifa.tdd.model.Task;
import com.khalifa.tdd.repository.TaskRepository;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @Test

    void updateTaskStatusTest() {
        // Arrange

        Task task = new Task(1L, "Test save test", "TODO");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // Act
        Task updatedTask = taskService.updateTaskStatus(1L, "DONE");

        // Assert
        assertNotNull(updatedTask);
        assertEquals("DONE", updatedTask.getStatus());
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).save(task);
    }
}