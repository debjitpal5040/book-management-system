package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debjit.pal.bookmanagementsystem.model.User;
import com.debjit.pal.bookmanagementsystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ArrayList<User> findAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public User findUserByID(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted with id: " + id;
    }

    @Override
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users deleted";
    }

}
