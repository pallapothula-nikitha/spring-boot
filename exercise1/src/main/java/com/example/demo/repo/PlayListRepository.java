package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PlayList;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList,Integer> {

}
