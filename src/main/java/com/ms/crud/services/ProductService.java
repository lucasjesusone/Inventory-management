package com.ms.crud.services;

import com.ms.crud.models.ProductModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductModel createProduct(ProductModel productModel) throws Exception {
        productModel.setCreatedAt(LocalDateTime.now());
        try {
            return productRepository.save(productModel);
        } catch (Exception e) {
                throw new Exception();
        }
    }
}
