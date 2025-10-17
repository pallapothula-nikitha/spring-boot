package com.js.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class OrderNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderNotificationServiceApplication.class, args);
	}

}
