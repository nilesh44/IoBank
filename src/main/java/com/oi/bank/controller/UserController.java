package com.oi.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oi.bank.service.UserService;
import com.oi.bank.vo.CreateUserRequest;
import com.oi.bank.vo.CreateUserResponse;
import com.oi.bank.vo.ExpireUserRequest;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
		CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
		return new ResponseEntity<CreateUserResponse>(createUserResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/expire", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> expireUser(@Valid @RequestBody ExpireUserRequest expireUserRequest) {
		userService.expireUser(expireUserRequest);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
