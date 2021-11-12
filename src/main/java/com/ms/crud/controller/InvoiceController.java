package com.ms.crud.controller;

import com.ms.crud.dtos.InvoiceDto;
import com.ms.crud.models.InvoiceModel;
import com.ms.crud.repositories.InvoiceRepository;
import com.ms.crud.services.InvoiceService;
import lombok.SneakyThrows;
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
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceRepository invoiceRepository;


    @SneakyThrows
    @PostMapping("/service/invoice/new")
    public ResponseEntity<InvoiceModel> newInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
        InvoiceModel invoiceModel = new InvoiceModel();
        BeanUtils.copyProperties(invoiceDto, invoiceModel);
        invoiceService.createInvoice(invoiceModel);
        return new ResponseEntity<>(invoiceModel, HttpStatus.CREATED);
    }


    @SneakyThrows
    @GetMapping("/service/invoice/getAll")
    public List<InvoiceModel> findAll() {

        return invoiceService.findAll();

    }


    @SneakyThrows
    @PutMapping(value = "/service/invoice/{invoice_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    InvoiceModel updateInvoice(@PathVariable Long invoice_id, @RequestBody InvoiceModel invoiceModel){
        InvoiceModel getId = invoiceRepository.findById(invoice_id).get();
        invoiceService.updateInvoice(getId);
        return invoiceModel;
    }


    @SneakyThrows
    @DeleteMapping("/service/invoice/{invoice_id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long invoice_id) {
        invoiceService.deleteInvoice(invoice_id);
        return new ResponseEntity<>("Invoice removed successfully",HttpStatus.OK);
    }



//public InvoiceModel updateInvoice(@PathVariable Long invoice_id, @RequestBody InvoiceModel invoiceModel){
//        clientModel.setUpdatedAt(LocalDateTime.now());        ClientModel c = clientRepository.findById(client_id).get();
//
//        InvoiceModel c = invoiceRepository.findById(invoice_id).get();
//
//
//        if(invoiceModel.getNatureOfOperation() != null)
//            c.setNetWeight(invoiceModel.getNetWeight());
//
//        if(invoiceModel.getCarrierAddress() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getCarrierCorporateName() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getCarrierCounty() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getCarrierIE() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getCarrierUF() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getCarrierVehiclePlate() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderAddress() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderCep() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderCorporateName() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderCounty() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderIE() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderUF() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderNeighborhood() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getSenderPhone() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getFreightCarrier() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getRecipientCep() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getRecipientAddress() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getRecipientCorporateName() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getRecipientCounty() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getRecipientCep() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//        if(invoiceModel.getRecipientNeighborhood() != null)
//            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());
//
//
//        invoiceService.updateInvoice(c);
//        return invoiceModel;
//    };
}