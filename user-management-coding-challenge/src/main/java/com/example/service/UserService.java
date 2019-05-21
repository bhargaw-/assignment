package com.example.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.example.model.User;

public interface UserService {
	
	User getUserById(UUID uuid);
	Page<User> getUsers(int pageNumber, int limit);
	User createUser(User user);

}
