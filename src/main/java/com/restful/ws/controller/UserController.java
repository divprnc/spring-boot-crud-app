package com.restful.ws.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.restful.ws.dto.UserDto;
import com.restful.ws.exception.ErrorDetails;
import com.restful.ws.exception.ResourceNotFoundException;
import com.restful.ws.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// build create User REST API
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	// Build get User by id REST API
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
		UserDto savedUser = userService.getUserById(userId);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}
	
	// Build get all users REST API
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	// Build update users REST API
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody @Valid UserDto user) {
		user.setId(userId);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		
	}
	
	// build delete user rest api
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User Deleted", HttpStatus.OK);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException execption, WebRequest webRequest) {
//		ErrorDetails errorDetails =new ErrorDetails(LocalDateTime.now(), execption.getMessage(), webRequest.getDescription(false), "USER_NOT_FOUND");
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//		
//	}
}
