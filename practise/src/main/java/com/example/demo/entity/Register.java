package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="register")
public class Register {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String username;
	private String password;
	private Timestamp createdAt;
	
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Register(Long id, String email, String username, String password, Timestamp createdAt) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
	}

	public Register(Long id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Register(String email, String username,  String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	
	
	
}
