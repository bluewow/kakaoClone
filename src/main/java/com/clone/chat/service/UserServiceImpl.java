package com.clone.chat.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clone.chat.domain.User;
import com.clone.chat.dto.UserDto;
import com.clone.chat.repository.UserRepository;
import com.clone.chat.util.exception.BusinessException;
import com.clone.chat.util.exception.ErrorCodes;
import com.clone.chat.util.exception.ErrorTrace;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Transactional
	@Override
	public void join(UserDto dto) {
		Optional<User> user = userRepository.findById(dto.getId());
		if(user.isPresent())
			 throw new BusinessException(ErrorCodes.DUPLICATED_ID, ErrorTrace.getName());
		
		userRepository.save(dto.toEntity());
	}

	@Override
	public void duplicateId(String userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
			throw new BusinessException(ErrorCodes.DUPLICATED_ID, ErrorTrace.getName());
		
	}
}
