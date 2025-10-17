package app;

import org.springframework.stereotype.Component;


@Component
public class PaymentMethod {
	public void processPayment(String t) {
		System.out.println(t);
	}
}
