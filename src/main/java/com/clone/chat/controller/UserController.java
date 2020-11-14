package com.clone.chat.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

import com.clone.chat.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("user")
@RestController
@CrossOrigin(origins = "http://3.35.140.126:9000/") //해당 origin 승인하기
public class UserController {

	//private final UserService userService;
	
	@PostMapping("/join")
	public void join(@RequestBody UserDto dto) throws JsonProcessingException {
		//userService.join(dto);
		
	}
	
	@PostMapping("/duplicate_check")
	public String duplicate(String id) throws JsonProcessingException {
		
		//TODO check user duplicate
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("return", "success");
		
		return new ObjectMapper().writeValueAsString(map);
	}

	@PostMapping("/login")
	public String login(String id) throws JsonProcessingException {
		
		//TODO get user data
		HashMap<String, String> map = new LinkedHashMap<>();
		map.put("id", "test@test.com");
		map.put("name", "KimKiHyun");
		map.put("phone", "010-xxxx-xxxx");
		map.put("img", "12345678-1234-5678-1234-567812345678");
		
		return new ObjectMapper().writeValueAsString(map);
	}
	
	@GetMapping("/image")
	public void getImage(String id, HttpServletResponse response) throws IOException {
		File file = new File("src/main/resources/static/image/sample.png");
		Files.copy(file.toPath(), response.getOutputStream());
		//TODO thumnail
	}
	
	@GetMapping("/image-list")
	public List<String> getImageList(HttpServletResponse response) throws IOException {
		List<String> list = new ArrayList<>();
		
		list.add("11111111-1234-5678-1234-567812345678");
		list.add("22222222-1234-5678-1234-567812345678");
		list.add("33333333-1234-5678-1234-567812345678");
		return list;
		
	}
	
}
