package com.example.todoapp.service;

import com.example.todoapp.domain.Task;
import com.example.todoapp.resource.TaskResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    List<Task> getAllTask();

    Optional<Task> getTaskById(Long id);

    String saveTask(TaskResource taskResource);

    String updateTaskById(Long id, TaskResource taskResource);

    String deleteTask(Long id);
}
