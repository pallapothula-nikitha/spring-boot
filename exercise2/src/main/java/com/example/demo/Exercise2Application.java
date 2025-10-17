package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Track;
import com.example.demo.service.TrackService;

@SpringBootApplication
public class Exercise2Application implements CommandLineRunner {
	
	@Autowired
	private TrackService trackService;

	public static void main(String[] args) {
		SpringApplication.run(Exercise2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Track t1 = new Track("money","echoes",LocalDate.of(2021, 10, 30),5000);	
		Track t2 = new Track("honey","shoes",LocalDate.of(2023, 12, 3),1000);
		Track t3 = new Track("lucky","ears",LocalDate.of(2025, 1, 14),500);
		
		trackService.addTrack(t3);
		trackService.addTrack(t2);
		trackService.addTrack(t1);
	}

}
