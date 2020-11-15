package com.clone.chat.controller.chat;

import java.util.List;

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
	public List<Long> roomList() {
		return null;
	}
}
