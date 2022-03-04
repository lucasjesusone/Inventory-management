package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.dtos.InvoiceProductDto;
import com.ms.InventoryManagement.models.InvoiceProductModel;
import com.ms.InventoryManagement.repositories.ProductRepository;
import com.ms.InventoryManagement.services.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class InvoiceProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;



    @SneakyThrows
    @PostMapping("/service/product/new")
    public ResponseEntity<InvoiceProductModel> newProduct(@RequestBody @Valid InvoiceProductDto invoiceProductDto){
        InvoiceProductModel invoiceProductModel = new InvoiceProductModel();
        BeanUtils.copyProperties(invoiceProductDto, invoiceProductModel);
        productService.createProduct(invoiceProductModel);
        return new ResponseEntity<>(invoiceProductModel, HttpStatus.CREATED);
    }


    @GetMapping("/service/product/getAll")
    public List<InvoiceProductModel> findAll() {

        return productService.findAll();

    }
}
