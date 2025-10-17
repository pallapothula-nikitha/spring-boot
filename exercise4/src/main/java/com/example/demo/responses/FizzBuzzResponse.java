package com.example.demo.responses;

public class FizzBuzzResponse {
	private String message;
	private String errorStatus;

	public FizzBuzzResponse() {
		// TODO Auto-generated constructor stub
	}

	public FizzBuzzResponse(String message, String errorStatus) {
		super();
		this.message = message;
		this.errorStatus = errorStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
	

}
