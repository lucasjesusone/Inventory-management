package com.ms.InventoryManagement.services;


import com.ms.InventoryManagement.models.ClientModel;
import com.ms.InventoryManagement.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public ClientModel createClient(ClientModel clientModel) {
        clientModel.setCreatedAt(Timestamp.from(Instant.now()));
        return clientRepository.save(clientModel);
    }

    public List<ClientModel> findAll() {
        return clientRepository.findAll();}


    public ClientModel getById(Long id_client) { return clientRepository.getById(id_client);

    }

    public ClientModel updateClient(ClientModel clientModel, Long id) {
        return clientRepository.save(clientModel);
    }

    public void deleteClient(Long id_client) {
        clientRepository.deleteById(id_client);
        ;}
}
