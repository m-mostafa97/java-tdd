package com.khalifa.tdd.cotroller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khalifa.tdd.controller.TaskController;
import com.khalifa.tdd.model.Task;
import com.khalifa.tdd.service.TaskService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {
    
    @MockBean
    TaskService taskService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGetAllTasks() throws Exception {
        // Arrange
        List<Task> tasks = List.of(
            new Task(1L, "Test save test", "TODO"),
            new Task(2L, "Test save test 2", "Done")
        );
        when(taskService.getAllTasks()).thenReturn(tasks);
        // Act & Assert
        mockMvc.perform(get("/tasks").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].title").value("Test save test"))
        .andExpect(jsonPath("$[1].title").value("Test save test 2"));
    }

    @Test
    void testCreateTask () throws Exception {
        // Arrange
        Task task = new Task(1L, "Test save test", "TODO");
        when(taskService.saveTask(task)).thenReturn(task);
        // Act & Assert
        mockMvc.perform(post("/tasks")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(task)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Test save test"));
    }
}