package com.example.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptions.BuzzException;
import com.example.demo.exceptions.FizzBuzzException;
import com.example.demo.exceptions.FizzException;
import com.example.demo.responses.GlobalError;

@RestControllerAdvice
public class FizzBuzzExceptionHandler {

	@ExceptionHandler(FizzException.class)
	public ResponseEntity<GlobalError> handleFizzException(FizzException ex){
		GlobalError error = new GlobalError(ex.getMessage(),"Internal Server error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	@ExceptionHandler(BuzzException.class)
	public ResponseEntity<GlobalError> handleBuzzException(BuzzException ex){
		GlobalError error = new GlobalError(ex.getMessage(),"Bad request");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(FizzBuzzException.class)
	public ResponseEntity<GlobalError> handleFizzBuzzException(FizzBuzzException ex){
		GlobalError error = new GlobalError(ex.getMessage(),"Insufficient Storage");
		return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(error);
	}
	

}
