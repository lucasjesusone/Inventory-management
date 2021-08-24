package com.ms.crud.services;

import com.ms.crud.models.ClientModel;
import com.ms.crud.models.InvoiceModel;
import com.ms.crud.models.ProductModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
