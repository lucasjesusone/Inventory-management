package com.ms.InventoryManagement.authentication.service;

import com.ms.InventoryManagement.models.UserModel;
import com.ms.InventoryManagement.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service(value = "UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel optionalUser = userRepository.findByUsername(username);
        if(optionalUser == null) {
            throw new UsernameNotFoundException("User related to ["+ username + "] not found");
        }

        return new UserDataDetails(optionalUser) {
        };

    }
}