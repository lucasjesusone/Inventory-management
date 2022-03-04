package com.ms.InventoryManagement.services;


import com.ms.InventoryManagement.models.ServiceModel;
import com.ms.InventoryManagement.repositories.ServiceRepository;
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
