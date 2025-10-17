package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Trader;
import com.example.demo.service.TraderService;

@SpringBootApplication
public class Exercise3Application implements CommandLineRunner{

	@Autowired
	private TraderService traderService;
	public static void main(String[] args) {
		SpringApplication.run(Exercise3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Trader t1 = new Trader("niki1","niki@gmail.com",13441);
		Trader t2 = new Trader("niki2","niki@gmail.in",13442);
		Trader t3 = new Trader("niki3","niki@gmail.co",13443);
		Trader t4 = new Trader("niki4","niki@gmail",13444);
		
		traderService.registerTrader(t1);
		traderService.registerTrader(t2);
		traderService.registerTrader(t3);
		traderService.registerTrader(t4);
		
	}

}
