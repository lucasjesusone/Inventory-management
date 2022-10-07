package com.ms.InventoryManagement.services;


import com.ms.InventoryManagement.models.ProductModel;
import com.ms.InventoryManagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public ProductModel create(ProductModel productModel) throws Exception {
//        invoiceItemsModel.setCreatedAt(LocalDateTime.now());
        try {
           ProductModel findProduct = productRepository.findByProductCode(productModel.getProductCode());
            if(findProduct != null) {
                findProduct.setQuantity(findProduct.getQuantity() + productModel.getQuantity());
                return productRepository.save(findProduct);
            }
            return productRepository.save(productModel);

        } catch (Exception e) {
                throw new Exception();
        }
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }
}
