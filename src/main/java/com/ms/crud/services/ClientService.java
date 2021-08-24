package com.ms.crud.services;


import com.ms.crud.models.ClientModel;
import com.ms.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public ClientModel createClient(ClientModel clientModel) {
        clientModel.setCreatedAt(LocalDateTime.now());
        return clientRepository.save(clientModel);
    }

    public List<ClientModel> findAll() {
        return clientRepository.findAll();}


    public ClientModel getById(Long id_client) { return clientRepository.getById(id_client);

    }

    public ClientModel updateClient(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    public void deleteClient(Long id_client) {
        clientRepository.deleteById(id_client);
        ;}
}
