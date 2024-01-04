package com.example.todoapp.controller;

import com.example.todoapp.domain.Employee;
import com.example.todoapp.resource.EmployeeResource;
import com.example.todoapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){

        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeResource employeeResource){

        return employeeService.saveEmployee(employeeResource);
    }

    @PutMapping("/{id}")
    public String updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeResource employeeResource){

        return employeeService.updateEmployeeById(id, employeeResource);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee (@PathVariable Long id){

        return employeeService.deleteEmployee(id);
    }


}
