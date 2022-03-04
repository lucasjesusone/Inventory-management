package com.ms.InventoryManagement.controller;

import com.ms.InventoryManagement.models.ResponseModel;
import com.ms.InventoryManagement.models.UserModel;
import com.ms.InventoryManagement.repositories.UserRepository;
import com.ms.InventoryManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/service/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody UserModel entity) {

        UserModel userModel = userService.newUser(entity);

        try {

            if(userModel == null) {
                return new ResponseEntity<>(new ResponseModel(0L,0, "user cannot be null"), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(new ResponseModel(entity.getId(),1, "user created successfully"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(0L,0, "user hasn't created successfully", e.getMessage(), ""), HttpStatus.CREATED);
        }
    }


    @GetMapping("/getAll")
    public List<UserModel> findAll() {

        return userService.findAll();

    }


    @GetMapping("/{id}")
    public ResponseEntity<UserModel> GetById(@PathVariable final Long id) throws Exception {
        Optional<UserModel> userModel = userService.getById(id);
        if(userModel.isPresent()) {
            return new ResponseEntity<>(userModel.get(), HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Optional<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel entity){
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isPresent()) {
            userService.updateUser(entity);
        }

        return user;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User removed successfully",HttpStatus.OK);
    }



}
