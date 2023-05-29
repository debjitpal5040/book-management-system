package com.debjit.pal.bookmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debjit.pal.bookmanagementsystem.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
}
