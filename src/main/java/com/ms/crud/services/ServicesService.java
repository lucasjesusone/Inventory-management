package com.ms.crud.services;


import com.ms.crud.models.ServiceModel;
import com.ms.crud.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicesService {
    @Autowired
    ServiceRepository serviceRepository;

    public ServiceModel createService(ServiceModel serviceModel) throws Exception {
        serviceModel.setCreatedAt(LocalDateTime.now());
        try {
            return serviceRepository.save(serviceModel);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
