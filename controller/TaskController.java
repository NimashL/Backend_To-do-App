package com.example.todoapp.controller;

import com.example.todoapp.domain.Task;
import com.example.todoapp.resource.TaskResource;
import com.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAllTask(){

        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){

        return taskService.getTaskById(id);
    }

    @PostMapping("/save")
    public String saveTask(@RequestBody TaskResource taskResource){

        return taskService.saveTask(taskResource);
    }

    @PutMapping("/{id}")
    public String updateTaskById(@PathVariable Long id, @RequestBody TaskResource taskResource){

        return taskService.updateTaskById(id, taskResource);
    }

    @DeleteMapping("/{id}")
    public String deleteTask (@PathVariable Long id){

        return taskService.deleteTask(id);
    }

}
