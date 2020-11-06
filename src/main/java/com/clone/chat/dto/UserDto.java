package com.clone.chat.dto;

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
}
