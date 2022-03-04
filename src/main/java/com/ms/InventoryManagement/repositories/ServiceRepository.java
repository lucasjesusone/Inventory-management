package com.ms.InventoryManagement.repositories;

import com.ms.InventoryManagement.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
