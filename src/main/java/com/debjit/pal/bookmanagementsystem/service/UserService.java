package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import com.debjit.pal.bookmanagementsystem.dto.UserDto;
import com.debjit.pal.bookmanagementsystem.model.User;

public interface UserService {
	// CREATE
	public User createUser(UserDto userDto);

	// READ
	public ArrayList<User> findAllUsers();
	public UserDto findUserByID(int userId);
	public UserDto findUserByName(String userName);
	// UPDATE
	public User updateUser(int userId, UserDto userDto);

	// DELETE
	public void deleteUserById(int userId);
	public void deleteUserByName(String userName);
	public void deleteAllUsers();
}
