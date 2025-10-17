package com.example.demo.model;

import java.sql.Timestamp;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;

@Entity
@Table(name="trader")
public class Trader {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private double balance;
	@CreatedDate
	@NotNull
	private Timestamp createdAt;
	@LastModifiedDate
	@NotNull
	private Timestamp updatedAt;
	public Trader() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trader(Long id, String name, String email, double balance, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Trader( String name, String email, double balance) {
		super();
	
		this.name = name;
		this.email = email;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
