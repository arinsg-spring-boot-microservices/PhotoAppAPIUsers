package com.arindamsg.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindamsg.photoapp.api.users.ui.models.UserRequestModel;
import com.arindamsg.photoapp.api.users.ui.models.UserResponseModel;
import com.arindamsg.photoapp.api.users.ui.services.UserService;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel user) {

		UserResponseModel userResponseModel = userService.createUser(user);
		return new ResponseEntity<>(userResponseModel, HttpStatus.CREATED);

	}
}
