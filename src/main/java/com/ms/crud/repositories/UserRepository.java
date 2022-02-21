package com.ms.crud.repositories;

import com.ms.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository  extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(String username);
    UserModel findByUserId(Integer userId);
}
