package com.clone.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("test")
	public String Hello() {
		
		return "HELLO";
	}
}
