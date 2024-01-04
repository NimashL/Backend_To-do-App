package com.example.todoapp.service.impl;

import com.example.todoapp.domain.Employee;
import com.example.todoapp.domain.Task;
import com.example.todoapp.repo.EmployeeRepository;
import com.example.todoapp.repo.TaskRepository;
import com.example.todoapp.resource.TaskResource;
import com.example.todoapp.service.EmployeeService;
import com.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Task> getAllTask(){

        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            return Optional.ofNullable(optionalTask.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String saveTask(TaskResource taskResource){
        Task task = new Task();
        Optional<Employee> existingEmployee = employeeRepository.findById(taskResource.getEmployeeId());

        task.setName(taskResource.getName());
        task.setDescription(taskResource.getDescription());
        task.setStatus(taskResource.getStatus());
        task.setCreatedDate(taskResource.getCreatedDate());
        task.setCreatedUser(taskResource.getCreatedUser());
        task.setModifiedDate(taskResource.getModifiedDate());
        task.setModifiedUser(taskResource.getModifiedUser());
        task.setEmployees(existingEmployee.get());

        taskRepository.save(task);
        return "record created successfully";
    }

    @Override
    public String updateTaskById(Long id, TaskResource taskResource){
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()){
            Task task = existingTask.get();
            task.setName(taskResource.getName());
            task.setDescription(taskResource.getDescription());
            task.setStatus(taskResource.getStatus());
            task.setCreatedDate(taskResource.getCreatedDate());
            task.setCreatedUser(taskResource.getCreatedUser());
            task.setModifiedDate(taskResource.getModifiedDate());
            task.setModifiedUser(taskResource.getModifiedUser());
            taskRepository.save(task);
            return "record updated successfully.";

        } else {
            return "record not found";
        }
    }

    @Override
    public String deleteTask(Long id){
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()){
            taskRepository.deleteById(id);
            return "record delete successfully";
        }else {
            return "record not found";
        }
    }

}
