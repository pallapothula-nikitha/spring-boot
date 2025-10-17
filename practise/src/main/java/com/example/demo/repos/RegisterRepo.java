package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Long>{

}
