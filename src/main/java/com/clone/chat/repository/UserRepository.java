package com.clone.chat.repository;

import com.clone.chat.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.chat.domain.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {


}
