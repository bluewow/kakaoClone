package com.clone.chat.controller.chat;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.chat.dto.ChatRoomDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("chat")
public class ChatController {

	@PostMapping("/room-create")
	public Long roomCreate(ChatRoomDto dto) {






		return 0L;
	}
	
	@GetMapping("/room-list")
	public List<Map<String,Object>> roomList() {
		List <Map<String,Object>> list = new ArrayList <Map<String,Object>>();
		Map<String,Object> data = new HashMap<String,Object>();

		data.put("chatroom1","study");
		data.put("chatroom2","friends");
		data.put("chatroom3","hobby");
		data.put("chatroom4","business");
		list.add(data);

		return list;
	}
}
