package com.ms.InventoryManagement.repositories;

import com.ms.InventoryManagement.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {


}
