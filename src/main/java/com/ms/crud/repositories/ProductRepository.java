package com.ms.crud.repositories;

import com.ms.crud.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{
}
