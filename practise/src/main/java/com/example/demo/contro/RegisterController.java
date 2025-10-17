package com.example.demo.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.Register;
import com.example.demo.service.RegisterService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins="http://localhost:5173")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/create")
	public void createUser(@RequestBody RegisterDTO r) {
		registerService.createUser(r);
	}

}
