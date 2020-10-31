package com.oi.bank.service;

import com.oi.bank.vo.CreateUserRequest;
import com.oi.bank.vo.CreateUserResponse;
import com.oi.bank.vo.ExpireUserRequest;

public interface UserService {
	
	public CreateUserResponse createUser(CreateUserRequest createUserRequest);
	
	public void expireUser(ExpireUserRequest expireUserRequest);

}
