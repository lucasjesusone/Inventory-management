package com.ms.crud.services;

import com.ms.crud.models.InvoiceProductModel;
import com.ms.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public InvoiceProductModel createProduct(InvoiceProductModel invoiceProductModel) throws Exception {
//        invoiceItemsModel.setCreatedAt(LocalDateTime.now());
        try {
            return productRepository.save(invoiceProductModel);
        } catch (Exception e) {
                throw new Exception();
        }
    }

    public List<InvoiceProductModel> findAll() {
        return productRepository.findAll();
    }
}
