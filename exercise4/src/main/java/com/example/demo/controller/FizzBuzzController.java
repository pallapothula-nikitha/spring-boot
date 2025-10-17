package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.BuzzException;
import com.example.demo.exceptions.FizzBuzzException;
import com.example.demo.exceptions.FizzException;
import com.example.demo.responses.FizzBuzzResponse;
import com.example.demo.responses.GlobalError;

@RestController
@RequestMapping("/controller_advice")
public class FizzBuzzController {
	
	@GetMapping("/{code}")
	public ResponseEntity<?> getResponse(@PathVariable String code){
		switch(code.toLowerCase()) {
		case "fizz":
			throw new FizzException("Fizz Exception has been thrown");
			
		case "buzz":
			throw new BuzzException("Buzz Exception has been thrown");
			
		case "fizzbuzz":
			throw new FizzBuzzException("Fizz Buzz Exception has been thrown");
			
		case "success":
			FizzBuzzResponse response= new FizzBuzzResponse("Successfully completed fizzbuzz test","200");
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		default:
			GlobalError error = new GlobalError("Invalid request","Bad Request");
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			//return ResponseEntity.badRequest().body(new GlobalError("Invalid request","Bad Request"));
		}
	}

}
