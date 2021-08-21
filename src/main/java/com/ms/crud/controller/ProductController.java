package com.ms.crud.controller;

import com.ms.crud.dtos.ProductDto;
import com.ms.crud.models.ProductModel;
import com.ms.crud.repositories.ProductRepository;
import com.ms.crud.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;



    @PostMapping("/service/product/new")
    public ResponseEntity<ProductModel> newProduct(@RequestBody @Valid ProductDto productDto) throws Exception {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDto, productModel);
        productService.createProduct(productModel);
        return new ResponseEntity<>(productModel, HttpStatus.CREATED);
    }

}
