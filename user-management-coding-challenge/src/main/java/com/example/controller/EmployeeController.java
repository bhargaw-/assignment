package com.example.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CustomResponse;
import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserService userService;

	public EmployeeController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user/{userId}")
	ResponseEntity<User> getUserById(@PathVariable("userId") UUID uuid) {
		logger.info("Requested userId {}", uuid);
		return ResponseEntity.ok(userService.getUserById(uuid));
	}

	@GetMapping({"/user/{pageNumber}/{limit}", "/user"})
	ResponseEntity<CustomResponse> getUsers(@PathVariable(name = "pageNumber", required = false) Integer pageNumber,
			@PathVariable(name = "limit", required = false) Integer limit) {
		
		pageNumber  = pageNumber == null ? 0 : pageNumber;
		limit = limit == null ? Integer.MAX_VALUE : limit;
	
		Page<User> page = userService.getUsers(pageNumber, limit);
		CustomResponse customResponse = new CustomResponse(page.getTotalPages(), page.getTotalElements(),
				page.getNumber(), page.getContent());
		
		logger.info("Finla Result {}", customResponse);
		return ResponseEntity.ok(customResponse);
	}

	@PostMapping("/user")
	ResponseEntity<User> createUser(@RequestBody User user) {
		user.setUuid(UUID.randomUUID());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}

}
