package com.clone.chat.service;

import java.util.List;

import com.clone.chat.dto.UserDto;

public interface UserService {

	/*
	 * 사용자 등록
	 */
	public void join(UserDto dto);
	
	/*
	 * 중복 체크
	 */
	public void duplicateId(String userId);
	
	/*
	 * 회원리스트 조회
	 */
	public List<String> getList(String id);
}
