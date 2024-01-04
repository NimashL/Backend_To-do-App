package com.example.todoapp.service.impl;

import com.example.todoapp.domain.Designation;
import com.example.todoapp.domain.Employee;
import com.example.todoapp.repo.DesignationRepository;
import com.example.todoapp.repo.EmployeeRepository;
import com.example.todoapp.resource.EmployeeResource;
import com.example.todoapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public List<Employee> getAllEmployee(){

        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            return Optional.ofNullable(optionalEmployee.get());
        } else
            return Optional.empty();
    }

    @Override
    public String saveEmployee(EmployeeResource employeeResource){
        Employee employee =new Employee();

        Optional<Designation> designation = designationRepository.findById(employeeResource.getDesignationId());

        employee.setDesignations(designation.get());
        employee.setFirstName(employeeResource.getFirstName());
        employee.setLastName(employeeResource.getLastName());
        employee.setEmail(employeeResource.getEmail());
        employee.setContactNumber(employeeResource.getContactNumber());
        employee.setStatus(employeeResource.getStatus());
        employee.setCreatedDate(employeeResource.getCreatedDate());
        employee.setCreatedUser(employeeResource.getCreatedUser());
        employee.setModifiedDate(employeeResource.getModifiedDate());
        employee.setModifiedUser(employeeResource.getModifiedUser());

        employeeRepository.save(employee);
        return "record created successfully";
    }

    @Override
    public String updateEmployeeById(Long id, EmployeeResource employeeResource){
        Optional<Employee> existingEmployee =employeeRepository.findById(id);
        if (existingEmployee.isPresent()){
            Employee employee = existingEmployee.get();
            employee.setFirstName(employeeResource.getFirstName());
            employee.setLastName(employeeResource.getLastName());
            employee.setContactNumber(employeeResource.getContactNumber());
            employee.setEmail(employeeResource.getEmail());
            employee.setStatus(employeeResource.getStatus());
            employee.setCreatedDate(employeeResource.getCreatedDate());
            employee.setCreatedUser(employeeResource.getCreatedUser());
            employee.setModifiedDate(employeeResource.getModifiedDate());
            employee.setModifiedUser(employeeResource.getModifiedUser());
            employeeRepository.save(employee);
            return "record updated successfully.";
        } else {
            return "record not found";
        }
    }

    @Override
    public String deleteEmployee(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            employeeRepository.deleteById(id);
            return "record delete successfully";
        } else {
            return "record not found";
        }
    }
}
