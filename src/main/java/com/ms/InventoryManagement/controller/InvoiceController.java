package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.models.InvoiceModel;
import com.ms.InventoryManagement.models.ResponseModel;
import com.ms.InventoryManagement.models.ServiceModel;
import com.ms.InventoryManagement.repositories.InvoiceRepository;
import com.ms.InventoryManagement.services.InvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/service/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceRepository invoiceRepository;


    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody InvoiceModel entity) throws Exception {

        InvoiceModel invoiceModel = invoiceService.create(entity);

        try {
            if(invoiceModel == null) {
                return new ResponseEntity<>(new ResponseModel(0L,0, "user cannot be null"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(0L,0, "user hasn't created successfully", e.getMessage(), ""), HttpStatus.CREATED);
        }


        return new ResponseEntity<>(new ResponseModel(entity.getInvoiceId(),1, "user created successfully"), HttpStatus.CREATED);
    }


    @GetMapping("/getAllInvoices")
    public List<InvoiceModel> findAll() {

        return invoiceService.findAll();

    }


    @PutMapping(value = "/{invoice_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    InvoiceModel updateInvoice(@PathVariable Long invoice_id, @RequestBody InvoiceModel invoiceModel){
        InvoiceModel invoice = invoiceRepository.findByinvoiceId(invoice_id);

        if(invoice != null) {
            invoiceService.updateInvoice(invoice);
        }

        return invoiceModel;
    }


    @DeleteMapping("/{invoice_id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long invoice_id) {
        invoiceService.deleteInvoice(invoice_id);
        return new ResponseEntity<>("Invoice removed successfully",HttpStatus.OK);
    }
}