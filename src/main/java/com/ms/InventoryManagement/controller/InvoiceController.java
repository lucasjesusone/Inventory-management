package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.dtos.InvoiceDto;
import com.ms.InventoryManagement.models.InvoiceModel;
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


    @PostMapping("/newInvoice")
    public ResponseEntity<InvoiceModel> newInvoice(@RequestBody @Valid InvoiceDto invoiceDto) throws Exception {
        InvoiceModel invoiceModel = new InvoiceModel();
        BeanUtils.copyProperties(invoiceDto, invoiceModel);
        invoiceService.createInvoice(invoiceModel);
        return new ResponseEntity<>(invoiceModel, HttpStatus.CREATED);
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