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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clone.chat.dto.ChatRoomDto;
import com.clone.chat.service.ChatService;
import com.clone.chat.util.ResponseForm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("chat")
public class ChatController {

	private final ChatService chatService;

	@PostMapping("/room-invite")
	public ResponseForm invite(@RequestParam List<String> users, Long chatRoomId) {
		chatService.invite(users, chatRoomId);

		return new ResponseForm();
	}
	
	@PostMapping("/room-create")
	public ResponseForm roomCreate(@RequestBody ChatRoomDto dto) {
		Long roomId = chatService.chatRoomCreate(dto);

		return new ResponseForm("roomId", roomId);
	}
	
	@GetMapping("/room-list")
	public ResponseForm roomList(String userId, String search, HttpServletRequest request) {
		List<ChatRoomDto.Response> list = chatService.getList(userId, search);
		HttpSession session = request.getSession();
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id",session.getAttribute("id"));
		return new ResponseForm("list", data);
	}

	//방입장시 알림메시지
	@MessageMapping("/hello/{roomNo}")
	@SendTo("/topic/greetings/{roomNo}")
	public Greeting greeting(ChatMessage message) throws Exception {
		Thread.sleep(100); // delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	//채팅 송신
	@MessageMapping("/chat/{roomNo}")
	@SendTo("/topic/chat/{roomNo}")
	public ChatRoomDto chat(ChatRoomDto chat) throws Exception {

		return new ChatRoomDto(chat.getName(), chat.getMessage());
	}





}
