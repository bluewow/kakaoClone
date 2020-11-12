package com.clone.chat.service;

import com.clone.chat.dto.UserDto;

public interface UserService {

	/*
	 * 사용자 등록
	 */
	public void join(UserDto dto);

	/*
	 * 로그인
	 */
	public void login(UserDto dto);


}
