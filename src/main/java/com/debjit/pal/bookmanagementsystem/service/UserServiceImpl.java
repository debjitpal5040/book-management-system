package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debjit.pal.bookmanagementsystem.dto.UserDto;
import com.debjit.pal.bookmanagementsystem.exception.ResourceNotFoundException;
import com.debjit.pal.bookmanagementsystem.model.User;
import com.debjit.pal.bookmanagementsystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return this.userRepository.save(user);
    }

    @Override
    public ArrayList<User> findAllUsers() {
        ArrayList<User> users = (ArrayList<User>) this.userRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }
        return users;
    }

    @Override
    public UserDto findUserByID(int userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userid", userId));
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto findUserByName(String userName) {
        User user = this.userRepository.findByUserName(userName);
        if (user == null) {
            throw new ResourceNotFoundException("User", "username", userName);
        }
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public User updateUser(int userId, UserDto userDto) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        if (userDto.getUserName() != null) {
            user.setUserName(userDto.getUserName());
        }
        if (userDto.getUserEmail() != null) {
            user.setUserEmail(userDto.getUserEmail());
        }
        if (userDto.getUserPhone() != null) {
            user.setUserPhone(userDto.getUserPhone());
        }
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUserById(int userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepository.delete(user);
    }

    @Override
    public void deleteUserByName(String userName) {
        User user = this.userRepository.findByUserName(userName);
        if (user == null) {
            throw new ResourceNotFoundException("User", "username", userName);
        }
        this.userRepository.delete(user);
    }

    @Override
    public void deleteAllUsers() {
        if (this.userRepository.count() == 0) {
            throw new ResourceNotFoundException("No users to delete");
        }
        this.userRepository.deleteAll();
    }

}
