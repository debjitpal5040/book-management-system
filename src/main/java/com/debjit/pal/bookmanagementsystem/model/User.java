package com.debjit.pal.bookmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username", nullable = false, unique = true)
    private String username;
    
    @Column(name="password", nullable = false)
    private String password;
    
    public User() {
    	
    }
    
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
    
    
}