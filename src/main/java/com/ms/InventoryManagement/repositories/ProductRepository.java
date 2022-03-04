package com.ms.InventoryManagement.repositories;

import com.ms.InventoryManagement.models.InvoiceProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<InvoiceProductModel, Long>{
}
