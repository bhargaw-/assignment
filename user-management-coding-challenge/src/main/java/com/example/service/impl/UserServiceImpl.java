package com.example.service.impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.UserCreationException;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(UUID uuid) {
		return userRepository.findById(uuid).<UserNotFoundException>orElseThrow(
				() -> new UserNotFoundException("No User is existed with userId :" + uuid.toString()));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> getUsers(int pageNumber, int limit) {
		return userRepository.findAll(PageRequest.of(pageNumber, limit));
	}

	@Override
	@Transactional(rollbackFor = UserCreationException.class, propagation = Propagation.REQUIRES_NEW)
	public User createUser(User user) {
		User newUser = userRepository.saveAndFlush(user);
		if (newUser == null) {
			throw new UserCreationException("Error, While creating user");
		}
		return newUser;
	}
}
