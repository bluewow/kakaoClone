package com.clone.chat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.clone.chat.util.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "chatroom")
public class ChatRoom extends BaseTimeEntity{
	
	@Id @Column(name = "chatroom_id", nullable = false)
	@GeneratedValue
	Long id;
	String name;
}
