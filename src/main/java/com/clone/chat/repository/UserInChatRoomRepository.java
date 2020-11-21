package com.clone.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.chat.domain.User;
import com.clone.chat.domain.UserInChatRoom;

public interface UserInChatRoomRepository extends JpaRepository<UserInChatRoom, Long>{

	public List<UserInChatRoom> findByUser(User user);
}
