package com.ms.crud.controller;

import com.ms.crud.dtos.UserDto;
import com.ms.crud.models.UserModel;
import com.ms.crud.services.UserService;
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
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/new")
    public ResponseEntity<UserModel> newUser(@RequestBody @Valid UserDto userDto) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userService.sendUser(userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);

    }


    @GetMapping("/service/user")
    public List<UserModel> findAll() {
        return userService.findAll();
    }


    @GetMapping("/service/user/{id}")
    public ResponseEntity<UserModel> GetById(@PathVariable final UUID id) throws Exception {
        Optional<UserModel> userModel = userService.getById(id);
        if(userModel.isPresent()) {
            return new ResponseEntity<>(userModel.get(), HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }


    @PutMapping("/service/user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable UUID id, @RequestBody @Valid UserModel userModel) {
        userModel.setUpdatedAt(LocalDateTime.now());
        userService.getById(id);
        return ResponseEntity.ok(userService.updateUser(userModel));

    }

    @DeleteMapping("/service/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User removed successfully",HttpStatus.OK);
    }



}
