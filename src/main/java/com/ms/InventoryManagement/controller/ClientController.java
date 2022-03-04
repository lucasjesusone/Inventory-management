package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.dtos.ClientDto;
import com.ms.InventoryManagement.models.ClientModel;
import com.ms.InventoryManagement.repositories.ClientRepository;
import com.ms.InventoryManagement.services.ClientService;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @SneakyThrows
    @PostMapping("/service/client/new")
    public ResponseEntity<ClientModel> newClient(@RequestBody @Valid ClientDto clientDto) {
        clientDto.setCreatedAt(Timestamp.from(Instant.now()));
        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);
        clientService.createClient(clientModel);
        return new ResponseEntity<>(clientModel, HttpStatus.CREATED);
    }

    @SneakyThrows
    @GetMapping("/service/client/getAll")
    public List<ClientModel> findAll() {
        return clientService.findAll();
    }


    @SneakyThrows
    @PutMapping(value = "/service/client/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> updateCliente(@PathVariable Long id, @RequestBody ClientModel clientModel) {
        clientModel.setUpdatedAt(Timestamp.from(Instant.now()));
        clientService.updateClient(clientModel, id);
        return ResponseEntity.ok(clientModel);
    }

    @SneakyThrows
    @DeleteMapping("/service/client/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id_client) {
        clientService.deleteClient(id_client);
        return new ResponseEntity<>("Client removed successfully", HttpStatus.OK);
    }
}
