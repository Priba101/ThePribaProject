package com.thepribaproject.webworld.service;

import com.thepribaproject.webworld.exception.UserNotFoundException;
import com.thepribaproject.webworld.repo.UserRepo;
import com.thepribaproject.webworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo employeeRepo) {
        this.userRepo = employeeRepo;
    }

    public User addUser(User user){

        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }
}
