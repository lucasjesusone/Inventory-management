package com.ms.crud.controller;

import com.ms.crud.dtos.ProductDto;
import com.ms.crud.dtos.ServiceDto;
import com.ms.crud.models.ProductModel;
import com.ms.crud.models.ServiceModel;
import com.ms.crud.repositories.ProductRepository;
import com.ms.crud.repositories.ServiceRepository;
import com.ms.crud.services.ProductService;
import com.ms.crud.services.ServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
public class ServiceController {

    @Autowired
    ServicesService servicesService;

    @Autowired
    ServiceRepository serviceRepository;



    @PostMapping("/service/service/new")
    public ResponseEntity<ServiceModel> newService(@RequestBody @Valid ServiceDto serviceDto) throws Exception {
        ServiceModel serviceModel = new ServiceModel();
        BeanUtils.copyProperties(serviceDto, serviceModel);
        servicesService.createService(serviceModel);
        return new ResponseEntity<>(serviceModel, HttpStatus.CREATED);
    }
}
