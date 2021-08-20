package com.ms.crud.repositories;

import com.ms.crud.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {


}
