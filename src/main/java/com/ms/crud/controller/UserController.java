package com.ms.crud.controller;

import com.ms.crud.dtos.UserDto;
import com.ms.crud.models.ClientModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.UserRepository;
import com.ms.crud.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/service/user/new")
    public ResponseEntity<UserModel> newUser(@RequestBody @Valid UserDto userDto) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userService.sendUser(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);

    }


    @GetMapping("/service/user/getAll")
    public List<UserModel> findAll() {

        return userService.findAll();

    }


    @GetMapping("/service/user/{id}")
    public ResponseEntity<UserModel> GetById(@PathVariable final Long id) throws Exception {
        Optional<UserModel> userModel = userService.getById(id);
        if(userModel.isPresent()) {
            return new ResponseEntity<>(userModel.get(), HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }


    @PutMapping("/service/user/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userModel) {
//        clientModel.setUpdatedAt(LocalDateTime.now());
        UserModel c = userRepository.findById(id).get();

        if(userModel.getFirstName() != null)
            c.setFirstName(userModel.getFirstName());

        if(userModel.getLastName() != null)
            c.setLastName(userModel.getLastName());

        if(userModel.getUsername() != null)
            c.setUsername(userModel.getUsername());

        if(userModel.getEmail() != null)
            c.setEmail(userModel.getEmail());

        if(userModel.getStatus() != null)
            c.setStatus(userModel.getStatus());


        userService.updateUser(c);
        return userModel;
    };

    @DeleteMapping("/service/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User removed successfully",HttpStatus.OK);
    }



}
