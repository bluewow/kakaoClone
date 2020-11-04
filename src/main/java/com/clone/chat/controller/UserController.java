package com.clone.chat.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.chat.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("user")
@RestController
public class UserController {

	@PostMapping("/join")
	public String join(@RequestBody UserDto dto) throws JsonProcessingException {

		//TODO logic
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("id", dto.getId());
		map.put("name", dto.getName());
		map.put("address", dto.getAddress());
		map.put("phone", dto.getPhone());
		map.put("email", dto.getEmail());
		
		return new ObjectMapper().writeValueAsString(map);
	}
	
	@PostMapping("/duplicate_check")
	public String duplicate(String id) throws JsonProcessingException {
		
		//TODO logic
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("return", "success");
		
		return new ObjectMapper().writeValueAsString(map);
	}

	@PostMapping("/login")
	public String login(String id) throws JsonProcessingException {
		
		//TODO logic
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("id", id);
		
		return new ObjectMapper().writeValueAsString(map);
	}
	
}
