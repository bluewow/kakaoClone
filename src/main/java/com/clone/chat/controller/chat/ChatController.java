package com.clone.chat.controller.chat;

import java.util.*;

import com.clone.chat.domain.ChatMessage;
import com.clone.chat.dto.Greeting;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.chat.dto.ChatRoomDto;
import com.clone.chat.service.ChatService;
import com.clone.chat.util.ResponseForm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.util.HtmlUtils;

@RequiredArgsConstructor
@RestController
@RequestMapping("chat")
public class ChatController {

	private final ChatService chatService;

	private final SimpMessageSendingOperations messagingTemplate;
	
	@PostMapping("/room-create")
	public ResponseForm roomCreate(@RequestBody ChatRoomDto dto) {
		Long roomId = chatService.chatRoomCreate(dto);

		return new ResponseForm("roomId", roomId);
	}
	
	@GetMapping("/room-list")
	public ResponseForm roomList(String userId) {
		//List<ChatRoomDto.Response> list = chatService.getList(userId);

		//임시
		List<String>data = new ArrayList<String>();

		data.add("room1");
		data.add("room2");
		data.add("room3");
		return new ResponseForm("list", data);
	}


	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(ChatMessage message) throws Exception {
		Thread.sleep(100); // delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

	@MessageMapping("/chat")
	@SendTo("/topic/chat")
	public ChatRoomDto chat(ChatRoomDto chat) throws Exception {
		//messagingTemplate.convertAndSend("/topic/chat/1", chat.getMessage());
		return new ChatRoomDto(chat.getName(), chat.getMessage());
	}





}
