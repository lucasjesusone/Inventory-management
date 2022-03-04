package com.ms.InventoryManagement.repositories;

import com.ms.InventoryManagement.models.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {

    InvoiceModel findByinvoiceId(Long InvoiceId);

}
