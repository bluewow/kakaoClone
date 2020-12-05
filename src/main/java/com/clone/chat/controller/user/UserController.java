package com.clone.chat.controller.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.chat.domain.User;
import com.clone.chat.dto.UserDto;
import com.clone.chat.service.UserService;
import com.clone.chat.util.ResponseForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

	private final UserService userService;
	
	@GetMapping("/list")
	public ResponseForm list(String id) {
		List<String> list = userService.getList(id);

		return new ResponseForm("list", list);
	}
	
	@PostMapping("/join")
	public ResponseForm join(@RequestBody UserDto dto) {
		userService.join(dto);

		return new ResponseForm();
	}
	
	@GetMapping("/duplicate_check")
	public ResponseForm duplicate(String id) {
		userService.duplicateId(id);
		
		return new ResponseForm();
	}

	@PostMapping("/login")
	public String login(@RequestBody UserDto dto) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		HashMap<String, String> map = new HashMap<>();

		if("abc@test.com".equals(dto.getId())&&"1234".equals(dto.getPw())){
			map.put("id", "test@test.com");
			map.put("name", "KimKiHyun");

		}else{
			map.put("fail", "fail");

		}


		
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
