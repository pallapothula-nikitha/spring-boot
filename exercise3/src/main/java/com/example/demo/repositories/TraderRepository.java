package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Trader;

@Repository
public interface TraderRepository extends JpaRepository<Trader,Long> {
	Trader findByEmail(String email); 
}
