package com.debjit.pal.bookmanagementsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.pal.bookmanagementsystem.model.User;
import com.debjit.pal.bookmanagementsystem.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    // create user rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.saveUser(user);
    }

    // get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userServiceImpl.findAllUsers();
    }

    // get users by id
    @GetMapping("/users/{id}")
    public User getUserUsingId(@PathVariable int id) {
        return userServiceImpl.findUserByID(id);
    }

    // update user rest api
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userDetails) {
        User user = userServiceImpl.findUserByID(id);

        if (userDetails.getUserName() != null) {
            user.setUserName(userDetails.getUserName());
        }
        if (userDetails.getUserEmail() != null) {
            user.setUserEmail(userDetails.getUserEmail());
        }
        if (userDetails.getUserPassword() != null) {
            user.setUserPassword(userDetails.getUserPassword());
        }
        if (userDetails.getUserRole() != null) {
            user.setUserRole(userDetails.getUserRole());
        }

        User updatedUser = userServiceImpl.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id) {
        userServiceImpl.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // delete all users rest api
    @DeleteMapping("/users")
    public String deleteAllUsers() {
        return userServiceImpl.deleteAllUsers();
    }

}
