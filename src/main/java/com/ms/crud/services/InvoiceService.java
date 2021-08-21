package com.ms.crud.services;

import com.ms.crud.models.InvoiceModel;
import com.ms.crud.models.ProductModel;
import com.ms.crud.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public InvoiceModel createInvoice(InvoiceModel invoiceModel) throws Exception {
        invoiceModel.setCreatedAt(LocalDateTime.now());
        try {
            return invoiceRepository.save(invoiceModel);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
