package com.ms.crud.controller;

import com.ms.crud.models.ResponseModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.UserRepository;
import com.ms.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;



    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody UserModel entity) throws Exception {

        UserModel userModel = userService.create(entity);
        if(userModel == null) {
            throw new Exception();
        }
        return new ResponseEntity<>(new ResponseModel(), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public List<UserModel> findAll() {

        return userService.findAll();

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel entity){
        UserModel note = userRepository.findByUserId(id);

        if(note != null) {
            userService.updateUser(entity);
        }

        return note;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(new ResponseModel(),HttpStatus.OK);
    }

}
