package com.restful.ws.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restful.ws.dto.UserDto;
import com.restful.ws.entity.User;
import com.restful.ws.exception.EmailAlreadyExistsException;
import com.restful.ws.exception.ResourceNotFoundException;
//import com.restful.ws.mapper.UserMapper;
import com.restful.ws.repository.UserRepository;
import com.restful.ws.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}


	@Override
	public UserDto createUser(UserDto userDto) {
		// convert User DTO into UserJpa Entity;
		
//		User user = UserMapper.mapToUser(userDto);
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		
		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists");
		}
		
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		
		// Convert User JP entity to UserDto Object
//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id)
		);
//		User user = optionalUser.get();
//		return UserMapper.mapToUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser = userRepository.findById(user.getId()).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", user.getId())
		);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
//		return UserMapper.mapToUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", id)
		);
		userRepository.deleteById(id);

	}

}
