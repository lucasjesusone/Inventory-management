package com.ms.crud.services;

import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserService {

        @Autowired
        UserRepository userRepository;

        PasswordEncoder passwordEncoder;

        public UserModel sendUser(UserModel userModel) {
                userModel.setCreatedAt(LocalDateTime.now());
                this.passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = this.passwordEncoder.encode(userModel.getPassword());
                userModel.setPassword(encodedPassword);
                return userRepository.save(userModel);
        }

        public List<UserModel> findAll() {
                return userRepository.findAll();

        }


        public Optional<UserModel> getById(Long id) {
                return userRepository.findById(id);
        }

        public UserModel updateUser(UserModel userModel) {
                return userRepository.save(userModel);
        }

        public void deleteUser(Long id) {
                userRepository.deleteById(id);
        ;}

}
