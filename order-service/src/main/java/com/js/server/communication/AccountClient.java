package com.js.server.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="account-service")
public interface AccountClient {
	@GetMapping("/accounts/{id}")
	String getAccount(@PathVariable String id);
}
