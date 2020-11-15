package com.clone.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.chat.domain.UserInChatRoom;

public interface UserInChatRepository extends JpaRepository<UserInChatRoom, Long>{

}
