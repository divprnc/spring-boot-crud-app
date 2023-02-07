package com.restful.ws.service;

import java.util.List;

import com.restful.ws.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto getUserById(Long id);
	List<UserDto> getAllUsers();
	UserDto updateUser(UserDto user);
	void deleteUser(Long id);
}
