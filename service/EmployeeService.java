package com.example.todoapp.service;

import com.example.todoapp.domain.Employee;
import com.example.todoapp.resource.EmployeeResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

     List<Employee> getAllEmployee();

     Optional<Employee> getEmployeeById(Long id);

     String saveEmployee (EmployeeResource employeeResource);

     String updateEmployeeById(Long id, EmployeeResource employeeResource); //byId remove

     String deleteEmployee(Long id);

}
