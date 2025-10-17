package com.js.server.controller;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
	private final JmsTemplate jmsTemplate;

	public OrderSender(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendOrder(String orderId) {
		jmsTemplate.convertAndSend("order.queue","New Order Id:"+orderId);
	}
	
}
