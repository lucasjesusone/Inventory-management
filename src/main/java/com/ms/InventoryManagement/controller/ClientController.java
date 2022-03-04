package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.models.ClientModel;
import com.ms.InventoryManagement.models.ResponseModel;
import com.ms.InventoryManagement.models.UserModel;
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


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody ClientModel entity) {

        ClientModel clientModel = clientService.createClient(entity);

        try{
            if(clientModel == null) {
                return new ResponseEntity<>(new ResponseModel(0L, 0, "user cannot be null"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(0L,0, "user hasn't created successfully", e.getMessage(), ""), HttpStatus.CREATED);
        }


        return new ResponseEntity<>(new ResponseModel(entity.getId(),1, "user created successfully"), HttpStatus.CREATED);
    }

    @SneakyThrows
    @GetMapping("/getAll")
    public List<ClientModel> findAll() {
        return clientService.findAll();
    }


    @SneakyThrows
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> updateCliente(@PathVariable Long id, @RequestBody ClientModel clientModel) {
        clientModel.setUpdatedAt(Timestamp.from(Instant.now()));
        clientService.updateClient(clientModel, id);
        return ResponseEntity.ok(clientModel);
    }

    @SneakyThrows
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id_client) {
        clientService.deleteClient(id_client);
        return new ResponseEntity<>("Client removed successfully", HttpStatus.OK);
    }
}
