package com.khalifa.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khalifa.tdd.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}