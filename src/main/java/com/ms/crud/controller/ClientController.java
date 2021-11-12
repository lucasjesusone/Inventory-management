package com.ms.crud.controller;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ms.crud.dtos.ClientDto;
import com.ms.crud.models.ClientModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.ClientRepository;
import com.ms.crud.services.ClientService;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/service/client/new")
    public ResponseEntity<ClientModel> newClient(@RequestBody @Valid ClientDto clientDto) {
        ClientModel clientModel = new ClientModel();
        clientModel.setCreatedAt(LocalDateTime.now());
        BeanUtils.copyProperties(clientDto, clientModel);
        clientService.createClient(clientModel);
        return new ResponseEntity<>(clientModel, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/service/client/getAll")
    public List<ClientModel> findAll() {return clientService.findAll();}


    @PutMapping("/service/client/{id_client}")
    public ClientModel updateClient(@PathVariable Long client_id, @RequestBody ClientModel clientModel) {
//        clientModel.setUpdatedAt(LocalDateTime.now());
        ClientModel c = clientRepository.findById(client_id).get();

      if(clientModel.getCnpj() != null)
          c.setCnpj(clientModel.getCnpj());

      if(clientModel.getStateRegistration() != null)
            c.setStateRegistration(clientModel.getStateRegistration());

      if(clientModel.getCorporateName() != null)
            c.setCorporateName(clientModel.getCorporateName());

      if(clientModel.getAddress() != null)
            c.setAddress(clientModel.getAddress());

      if(clientModel.getNeighborhood() != null)
            c.setNeighborhood(clientModel.getNeighborhood());

      if(clientModel.getCep() != null)
            c.setCep(clientModel.getCep());

      if(clientModel.getPhoneNumber() != null)
            c.setPhoneNumber(clientModel.getPhoneNumber());

      if(clientModel.getUf() != null)
            c.setUf(clientModel.getUf());

      if(clientModel.getCity() != null)
          c.setCity(clientModel.getCity());

      if(clientModel.getCreatedAt() != null)
          c.setCreatedAt(clientModel.getCreatedAt());

      if(clientModel.getStatus() != null)
          c.setStatus(clientModel.getStatus());

//      if(clientModel.getClient_id() !=null )
//          c.setClient_id(clientModel.getClient_id());

      clientService.updateClient(c);
      return clientModel;
    };

    @DeleteMapping("/service/client/{id_client}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id_client) {
        clientService.deleteClient(id_client);
        return new ResponseEntity<>("Client removed successfully",HttpStatus.OK);
    }
}
