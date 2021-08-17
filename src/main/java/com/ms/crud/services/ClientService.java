package com.ms.crud.services;


import ch.qos.logback.core.net.server.Client;
import com.ms.crud.models.ClientModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<ClientModel> getById(Long id_client) { return clientRepository.findById(id_client);

    }

    public ClientModel updateClient(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    public void deleteClient(Long id_client) {
        clientRepository.deleteById(id_client);
        ;}
}
