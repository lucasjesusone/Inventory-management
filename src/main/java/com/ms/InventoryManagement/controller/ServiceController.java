package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.models.ResponseModel;
import com.ms.InventoryManagement.models.ServiceModel;
import com.ms.InventoryManagement.repositories.ServiceRepository;
import com.ms.InventoryManagement.services.ServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service/service")
public class ServiceController {

    @Autowired
    ServicesService servicesService;

    @Autowired
    ServiceRepository serviceRepository;



    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody ServiceModel entity) throws Exception {

        ServiceModel serviceModel = servicesService.create(entity);

        try {
            if(serviceModel == null) {
                return new ResponseEntity<>(new ResponseModel(0L,0, "user cannot be null"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(0L,0, "user hasn't created successfully", e.getMessage(), ""), HttpStatus.CREATED);
        }


        return new ResponseEntity<>(new ResponseModel(entity.getId(),1, "user created successfully"), HttpStatus.CREATED);
    }
}
