package com.clone.chat.service;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
		if (user.isPresent())
			throw new BusinessException(ErrorCodes.DUPLICATED_ID, ErrorTrace.getName());

		userRepository.save(dto.toEntity());
	}

	@Override
	public void duplicateId(String userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
			throw new BusinessException(ErrorCodes.DUPLICATED_ID, ErrorTrace.getName());

	}

	@Override
	public List<String> getList(String id) {
		List<User> list = userRepository.findAll();
		List<String> response = new ArrayList<>();

		list.forEach(l -> {
			if (!l.getId().equals(id))
				response.add(l.getId());
		});


		return response;
	}













	public String create(String userId) throws UnsupportedEncodingException {
		List<String> authList = new ArrayList();
		authList.add(userId);

		String jwt = Jwts.builder()
				.setIssuer("Stormpath")
				.setSubject("msilverman")
				.claim("scope", authList)
				.claim("name", "Micah Silverman")
				.setIssuedAt(Date.from(Instant.now()))
				.setExpiration(Date.from(Instant.now().plus(2, ChronoUnit.HOURS)))
				.signWith(SignatureAlgorithm.HS256,
						"secret".getBytes("UTF-8"))
				.compact();

		System.out.println(jwt);

		return jwt;
	}


	public void validate(String jwt) throws UnsupportedEncodingException{
		Claims claims =
				Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt).getBody();

		System.out.println(claims);
		System.out.println(claims.get("scope"));


	}




}