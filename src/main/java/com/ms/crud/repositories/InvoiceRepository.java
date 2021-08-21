package com.ms.crud.repositories;

import com.ms.crud.models.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
}
