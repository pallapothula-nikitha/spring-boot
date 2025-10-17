package com.js.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderSender sender;
	
	@Value("${sender.name}")
	private String nameFromConfig;

	public OrderController(OrderSender sender) {
		this.sender = sender;
	}
	
	@GetMapping("/sendfromconfig")
	public ResponseEntity<String> getProductFromConfig(){
		return ResponseEntity.ok("Config ok: " + nameFromConfig);
	}
	
	@PostMapping("/{id}")
	public String createOrder(@PathVariable String id) {
		sender.sendOrder(id);
		return "Order " +id+"Created and sent to quuee";
	}
	

}
