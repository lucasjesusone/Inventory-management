package com.ms.InventoryManagement.repositories;

import com.ms.InventoryManagement.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

    ProductModel findByProductCode(Integer productCode);
}
