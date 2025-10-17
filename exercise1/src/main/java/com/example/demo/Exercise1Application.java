package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.PlayList;
import com.example.demo.services.PlaylistService;

@SpringBootApplication
public class Exercise1Application implements CommandLineRunner{

	@Autowired
	private PlaylistService service;
	public static void main(String[] args) {
		SpringApplication.run(Exercise1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		PlayList p1= new PlayList("niki",23);
		PlayList p2= new PlayList("nikitha",53);
		PlayList p3= new PlayList("pandu",53);
		PlayList p4= new PlayList("niha",53);
		PlayList p5= new PlayList("nitha",53);
		PlayList p6= new PlayList("kitha",53);
		service.addPlaylist(p2);
		service.addPlaylist(p1);
		service.addPlaylist(p3);
		service.addPlaylist(p4);
		service.addPlaylist(p5);service.addPlaylist(p6);
	}

}
