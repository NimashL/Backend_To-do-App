package com.example.todoapp.controller;

import com.example.todoapp.domain.Designation;
import com.example.todoapp.resource.DesignationResource;
import com.example.todoapp.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/designation")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @GetMapping("/all")
    public List<Designation> getAllDesignation(){

        return designationService.getAllDesignation();
    }

    @GetMapping("/{id}")
    public Optional<Designation> getDesignationById(@PathVariable Long id){

        return designationService.getDesignationById(id);
    }

    @PostMapping("/save")
    public String saveDesignation(@RequestBody DesignationResource designationResource){

        return designationService.saveDesignation(designationResource);
    }

    @PutMapping("/{id}")
    public String updateDesignation(@PathVariable Long id, @RequestBody DesignationResource designationResource){

        return designationService.updateDesignation(id, designationResource);
    }

    @DeleteMapping("/{id}")
    public String deleteDesignationById(@PathVariable Long id){

        return designationService.deleteDesignationById(id);

    }

}
