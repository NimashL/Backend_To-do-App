package com.example.todoapp.service;

import com.example.todoapp.domain.Designation;
import com.example.todoapp.resource.DesignationResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DesignationService {

    List<Designation> getAllDesignation();

    Optional<Designation> getDesignationById(Long id);

    String saveDesignation(DesignationResource designationResource);

    String updateDesignation(Long id, DesignationResource designationResource);

   String deleteDesignationById(Long id);

}
