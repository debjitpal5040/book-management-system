package com.debjit.pal.bookmanagementsystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.pal.bookmanagementsystem.dto.UserDto;
import com.debjit.pal.bookmanagementsystem.model.User;
import com.debjit.pal.bookmanagementsystem.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    // create user rest api
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User newUser = userServiceImpl.createUser(userDto);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    // get all users rest api
    @GetMapping("/users")
    public ResponseEntity<ArrayList<UserDto>> getAllUsers() {
        ArrayList<UserDto> userDtos = this.userServiceImpl.findAllUsers();
        return new ResponseEntity<ArrayList<UserDto>>(userDtos, HttpStatus.OK);
    }

    // get user by id rest api
    @GetMapping("/users/userid/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") int userId) {
        // convert user to userDto
        UserDto userDto = this.userServiceImpl.findUserByID(userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    // get user by name rest api
    @GetMapping("/users/username/{userName}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable("userName") String userName) {
        // convert user to userDto
        UserDto userDto = this.userServiceImpl.findUserByName(userName);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }

    // update user rest api
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser (@PathVariable int userId, @RequestBody @Valid UserDto userDto) {
        User updatedUser = userServiceImpl.updateUser(userId, userDto);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    // delete user by id rest api
    @DeleteMapping("/users/userid/{userId}")
    public String deleteUserById(@PathVariable int userId) {
        this.userServiceImpl.deleteUserById(userId);
        return "User deleted with id: " + userId;
    }

    // delete user by name rest api
        @DeleteMapping("/users/username/{userName}")
        public String deleteUserByName(@PathVariable String userName) {
            this.userServiceImpl.deleteUserByName(userName);
            return "User deleted with username: " + userName;
        }

    // delete all users rest api
    @DeleteMapping("/users")
    public String deleteAllUsers() {
        this.userServiceImpl.deleteAllUsers();
        return "All users deleted";
    }

}
