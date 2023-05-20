package com.debjit.pal.bookmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.debjit.pal.bookmanagementsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
