package com.ms.crud.repositories;

import com.ms.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserModel, UUID> {
}
