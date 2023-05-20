package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import com.debjit.pal.bookmanagementsystem.model.User;

public interface UserService {
	// CREATE
	public User saveUser(User user);

	// READ
	public ArrayList<User> findAllUsers();

	public User findUserByID(int id);
	// UPDATE
	public User updateUser(User user);

	// DELETE
	public String deleteUser(int id);
	public String deleteAllUsers();

}
