package com.arindamsg.photoapp.api.users.ui.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestModel {
	@NotNull(message = "Required Field is missing : First name")
	@Size(min = 1, max = 50, message = "First Name should be between 1 and 50 characters")
	private String firstName;
	@NotNull(message = "Required Field is missing : Last name")
	@Size(min = 1, max = 50, message = "Last Name should be between 1 and 50 characters")
	private String lastName;
	@NotNull(message = "Required Field is missing : Email")
	@Size(min = 1, max = 150, message = "Email should be between 1 and 150 characters")
	@Email(message = "Please enter valid email id")
	private String email;
	@NotNull(message = "Required Field is missing : Password")
	@Size(min = 6, max = 20, message = "First Name should be between 6 and 20 characters")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
