package com.ms.InventoryManagement.services;

import com.ms.InventoryManagement.models.InvoiceModel;
import com.ms.InventoryManagement.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public InvoiceModel createInvoice(InvoiceModel invoiceModel) throws Exception {
//        invoiceModel.setCreatedAt(LocalDateTime.now());
        try {
            return invoiceRepository.save(invoiceModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    public List<InvoiceModel> findAll() {
        return invoiceRepository.findAll();

    }
    public InvoiceModel updateInvoice(InvoiceModel invoiceModel) {
        return invoiceRepository.save(invoiceModel);
    }

    public void deleteInvoice(Long invoice_id) {
        invoiceRepository.deleteById(invoice_id);
    }


}
