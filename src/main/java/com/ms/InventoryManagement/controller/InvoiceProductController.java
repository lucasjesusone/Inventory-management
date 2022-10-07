package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.models.ProductModel;
import com.ms.InventoryManagement.models.ResponseModel;
import com.ms.InventoryManagement.repositories.ProductRepository;
import com.ms.InventoryManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service/product")
public class InvoiceProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;



    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody ProductModel entity) throws Exception {

        ProductModel productModel = productService.create(entity);

        try {
            if(productModel == null) {
                return new ResponseEntity<>(new ResponseModel(0L,0, "user cannot be null"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(0L,0, "user hasn't created successfully", e.getMessage(), ""), HttpStatus.CREATED);
        }


        return new ResponseEntity<>(new ResponseModel(entity.getProductId(),1, "user created successfully"), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public List<ProductModel> findAll() {

        return productService.findAll();

    }

    public String hello() {
        return "teste";
    }
}
