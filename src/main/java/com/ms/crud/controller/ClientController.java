package com.ms.crud.controller;

import ch.qos.logback.core.net.server.Client;
import com.ms.crud.dtos.ClientDto;
import com.ms.crud.models.ClientModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.services.ClientService;
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

    @PostMapping("/service/client/new")
    public ResponseEntity<ClientModel> newClient(@RequestBody @Valid ClientDto clientDto) {
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);
        clientService.createClient(clientModel);
        return new ResponseEntity<>(clientModel, HttpStatus.CREATED);
    }


    @GetMapping("/service/client/getAll")
    public List<ClientModel> findAll() {return clientService.findAll();}


    @PutMapping("/service/client/{id_client}")
    public ResponseEntity<ClientModel> updateUser(@PathVariable Long id_client, @RequestBody @Valid ClientModel clientModel) {
        clientModel.setUpdatedAt(LocalDateTime.now());
        clientService.getById(id_client);
        return ResponseEntity.ok(clientService.updateClient(clientModel));
    }

    @DeleteMapping("/service/client/{id_client}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id_client) {
        clientService.deleteClient(id_client);
        return new ResponseEntity<>("Client removed successfully",HttpStatus.OK);
    }
}
