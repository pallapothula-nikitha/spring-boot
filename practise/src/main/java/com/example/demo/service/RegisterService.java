package com.example.demo.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.Register;
import com.example.demo.repos.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepo registerRepo;
	
	public Register createUser(RegisterDTO r) {
		
		Register r2= new Register(r.getEmail(),r.getUsername(),r.getPassword());
		r2.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		return registerRepo.save(r2);
	}
	
}
