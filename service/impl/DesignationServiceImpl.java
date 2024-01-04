package com.example.todoapp.service.impl;

import com.example.todoapp.domain.Designation;
import com.example.todoapp.repo.DesignationRepository;
import com.example.todoapp.resource.DesignationResource;
import com.example.todoapp.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public List<Designation> getAllDesignation(){
        return designationRepository.findAll();
    }

    @Override
    public Optional<Designation> getDesignationById(Long id){
        Optional<Designation> optionalDesignation = designationRepository.findById(id);
        if(optionalDesignation.isPresent()){
            return Optional.ofNullable(optionalDesignation.get());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String saveDesignation(DesignationResource designationResource){
        Designation designation = new Designation();

        designation.setCode(designationResource.getCode());
        designation.setName(designationResource.getName());
        designation.setName(designationResource.getName());
        designation.setStatus(designationResource.getStatus());
        designation.setCreatedDate(designationResource.getCreatedDate());
        designation.setCreatedUser(designationResource.getCreatedUser());
        designation.setModifiedDate(designationResource.getModifiedDate());
        designation.setModifiedUser(designationResource.getModifiedUser());

        designationRepository.save(designation);
        return "record created successfully";
    }

    @Override
    public String updateDesignation(Long id, DesignationResource designationResource){
        Optional<Designation> existingDesignation = designationRepository.findById(id);
        if (existingDesignation.isPresent()){
            Designation designation = existingDesignation.get();
            designation.setCode(designationResource.getCode());
            designation.setName(designationResource.getName());
            designation.setStatus(designationResource.getStatus());
            designation.setCreatedDate(designationResource.getCreatedDate());
            designation.setCreatedUser(designationResource.getCreatedUser());
            designation.setModifiedDate(designationResource.getModifiedDate());
            designation.setModifiedUser(designationResource.getModifiedUser());
            designationRepository.save(designation);
            return "record updated successfully.";

        } else {
            return "record not found";
        }

    }

    @Override
    public String deleteDesignationById(Long id){
        Optional<Designation> optionalDesignation = designationRepository.findById(id);
        if (optionalDesignation.isPresent()){
            designationRepository.deleteById(id);
            return "record delete successfully";
        } else {
            return "record not found";
        }
    }

}
