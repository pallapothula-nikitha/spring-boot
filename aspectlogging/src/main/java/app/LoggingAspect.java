package app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* app.PaymentMethod.*(..))")
	public void logBeforeMethodCall(JoinPoint j) {
		System.out.println("Log: before " +j.getSignature().getName());
	}
	
	@After("execution(* app.PaymentMethod.*(..))")
	public void logAfterMethodCall(JoinPoint j) {
		System.out.println("Log: after " +j.getSignature().getName());
	}
}
