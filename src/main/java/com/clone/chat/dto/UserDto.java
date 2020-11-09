package com.clone.chat.dto;

import com.clone.chat.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class UserDto {
	String id;
	String pw;
	String name;
	String image;
	String phone;
	
	public User toEntity() {
		return User.builder()
			.id(id)
			.pw(pw)
			.name(name)
			.phone(phone)
			.build();
	}
}
