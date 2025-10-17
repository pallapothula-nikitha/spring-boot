package com.js.server.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationReciver {
	@JmsListener(destination ="order.queue")
	public void receiveOrder(String msg) {
		System.out.println("Notification Recieved: "+msg);
	}
}
