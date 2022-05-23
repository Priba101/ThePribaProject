package com.thepribaproject.webworld.repo;

import com.thepribaproject.webworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
}
