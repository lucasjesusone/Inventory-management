package com.ms.crud.services;

import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserService {

        @Autowired
        UserRepository userRepository;

        PasswordEncoder passwordEncoder;

        public UserModel sendUser(UserModel userModel) {
                this.passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = this.passwordEncoder.encode(userModel.getPassword());
                userModel.setPassword(encodedPassword);
                return userRepository.save(userModel);
        }

        public List<UserModel> findAll() {
                return userRepository.findAll();
        }


        public Optional<UserModel> getById(UUID id) {return userRepository.findById(id);}


        public void deleteUser(UUID id) {
                userRepository.deleteById(id);
        ;}

}
