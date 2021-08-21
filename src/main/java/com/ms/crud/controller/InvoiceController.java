package com.ms.crud.controller;

import com.ms.crud.dtos.InvoiceDto;
import com.ms.crud.dtos.ProductDto;
import com.ms.crud.models.InvoiceModel;
import com.ms.crud.models.ProductModel;
import com.ms.crud.services.InvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/service/invoice/new")
    public ResponseEntity<InvoiceModel> newInvoice(@RequestBody @Valid InvoiceDto invoiceDto) throws Exception {
        InvoiceModel invoiceModel = new InvoiceModel();
        BeanUtils.copyProperties(invoiceDto, invoiceModel);
        invoiceService.createInvoice(invoiceModel);
        return new ResponseEntity<>(invoiceModel, HttpStatus.CREATED);
    }
}
