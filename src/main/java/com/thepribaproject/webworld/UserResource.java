package com.thepribaproject.webworld;

import com.thepribaproject.webworld.model.User;
import com.thepribaproject.webworld.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> employees = userService.findAllUsers();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCurrentUsersCount(){
        Integer numberOfUsers = userService.findAllUsers().size();
        return new ResponseEntity<>(numberOfUsers,HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User employee = userService.findUserById(id);
        return new ResponseEntity<User>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User employee) {
        User newEmployee = userService.addUser(employee);
        return new ResponseEntity<User>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User employee){
        User updateEmployee = userService.updateUser(employee);
        return new ResponseEntity<User>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 }