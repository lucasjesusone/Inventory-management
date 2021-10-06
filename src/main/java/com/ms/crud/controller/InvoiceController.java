package com.ms.crud.controller;

import com.ms.crud.dtos.InvoiceDto;
import com.ms.crud.dtos.ProductDto;
import com.ms.crud.models.ClientModel;
import com.ms.crud.models.InvoiceModel;
import com.ms.crud.repositories.InvoiceRepository;
import com.ms.crud.services.InvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceRepository invoiceRepository;

    @CrossOrigin
    @PostMapping("/service/invoice/new")
    public ResponseEntity<InvoiceModel> newInvoice(@RequestBody @Valid InvoiceDto invoiceDto) throws Exception {
        InvoiceModel invoiceModel = new InvoiceModel();
        BeanUtils.copyProperties(invoiceDto, invoiceModel);
        invoiceService.createInvoice(invoiceModel);
        return new ResponseEntity<>(invoiceModel, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping("/service/invoice/getAll")
    public List<InvoiceModel> findAll() {

        return invoiceService.findAll();

    }

    @PutMapping("/service/invoice/{invoice_id}")
    public InvoiceModel updateInvoice(@PathVariable Long invoice_id, @RequestBody InvoiceModel invoiceModel){
//        clientModel.setUpdatedAt(LocalDateTime.now());        ClientModel c = clientRepository.findById(client_id).get();

        InvoiceModel c = invoiceRepository.findById(invoice_id).get();

        if(invoiceModel.getCfop() != null)
            c.setCfop(invoiceModel.getCfop());

        if(invoiceModel.getFreight() != null)
            c.setFreight(invoiceModel.getFreight());

        if(invoiceModel.getNcm_sh() != null)
            c.setNcm_sh(invoiceModel.getNcm_sh());

        if(invoiceModel.getQtd() != null)
            c.setQtd(invoiceModel.getQtd());

        if(invoiceModel.getProduct_code() != null)
            c.setProduct_code(invoiceModel.getProduct_code());

        if(invoiceModel.getProduct() != null)
            c.setProduct(invoiceModel.getProduct());

        if(invoiceModel.getClient() != null)
            c.setClient(invoiceModel.getClient());

        if(invoiceModel.getCst() != null)
            c.setCst(invoiceModel.getCst());

        if(invoiceModel.getNatureOfOperation() != null)
            c.setNatureOfOperation(invoiceModel.getNatureOfOperation());

        invoiceService.updateInvoice(c);
        return invoiceModel;
    };


    @DeleteMapping("/service/invoice/{invoice_id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long invoice_id) {
        invoiceService.deleteInvoice(invoice_id);
        return new ResponseEntity<>("Invoice removed successfully",HttpStatus.OK);
    }
}
