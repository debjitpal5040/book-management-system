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
    public ArrayList<User> findAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

}
