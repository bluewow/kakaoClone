package com.clone.chat.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clone.chat.domain.User;
import com.clone.chat.dto.UserDto;
import com.clone.chat.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	//private final UserRepository userRepository;


	@Override
	public void join(UserDto dto) {
		//User user = userRepository.save(dto.toEntity());

		//if(user == null)
			//throw new ExceptionInInitializerError();
	}
}
