package com.clone.chat.dto;

import java.time.LocalDateTime;

import com.clone.chat.domain.ChatRoom;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ChatRoomDto {

	String chatRoomName;
	String userId;
	
	public ChatRoom toEntity() {
		return ChatRoom.builder()
				.name(chatRoomName)
				.admin(userId)
				.build();
	}

	@Getter
	@Setter
	public static class Response {
		String chatRoomName;
		LocalDateTime modifiedDate;
		Long unreadMsgCount;
		String lastMsg;
	}
}
