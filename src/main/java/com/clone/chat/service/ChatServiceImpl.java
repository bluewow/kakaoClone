package com.clone.chat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clone.chat.domain.ChatRoom;
import com.clone.chat.domain.User;
import com.clone.chat.domain.UserInChatRoom;
import com.clone.chat.dto.ChatRoomDto;
import com.clone.chat.dto.ChatRoomDto.Response;
import com.clone.chat.repository.ChatRoomRepository;
import com.clone.chat.repository.UserInChatRoomRepository;
import com.clone.chat.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService{

	private final UserRepository userRepository;
	private final ChatRoomRepository chatRoomRepository;
	private final UserInChatRoomRepository userInChatRoomRepository;
	
	@Transactional
	@Override
	public Long chatRoomCreate(ChatRoomDto dto) {
		ChatRoom chatRoom = chatRoomRepository.save(dto.toEntity());
		
		//연결테이블 처리
		User user = userRepository.getOne(dto.getUserId());
		UserInChatRoom userInChatRoom = new UserInChatRoom(chatRoom, user, true);
		userInChatRoomRepository.save(userInChatRoom);
		
		return chatRoom.getId();
	}

	@Override
	public List<Response> getList(String userId) {
		User user = userRepository.getOne(userId);
		List<UserInChatRoom> list = userInChatRoomRepository.findByUser(user);
		
		return toDto(list);
	}

	private List<Response> toDto(List<UserInChatRoom> list) {
		List<Response> dtoList = new ArrayList<>();
		
		for(UserInChatRoom userInChatRoom : list) {
			Response response = new Response();
			response.setChatRoomName(userInChatRoom.getChatRoom().getName());
			response.setLastMsg(null);
			response.setModifiedDate(userInChatRoom.getChatRoom().getModifiedDate());
			response.setUnreadMsgCount(null);
			
			dtoList.add(response);
		}
		return dtoList;
	}
}