package com.restful.ws.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	
	private Long id;
	@NotEmpty(message = "User First Name should not be null or empty")
	private String firstName;
	@NotEmpty(message = "User Last Name should not be null or empty")
	private String lastName;
	@NotEmpty(message = "User Email Name should not be null or empty")
	@Email(message = "Please Enter the valid email address")
	private String email;

	public UserDto() {
		super();
	}

	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
