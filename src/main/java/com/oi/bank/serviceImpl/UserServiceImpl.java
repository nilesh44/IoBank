package com.oi.bank.serviceImpl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oi.bank.entity.User;
import com.oi.bank.exception.RecordNotCreated;
import com.oi.bank.exception.RecordNotFound;
import com.oi.bank.repository.UserRepo;
import com.oi.bank.service.UserService;
import com.oi.bank.vo.CreateUserRequest;
import com.oi.bank.vo.CreateUserResponse;
import com.oi.bank.vo.ExpireUserRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
		CreateUserResponse createUserResponse = new CreateUserResponse();
		User user = new User(createUserRequest);
		try {
			userRepo.save(user);
		} catch (Exception e) {
			throw new RecordNotCreated("error in creating user",e);
		}
		createUserResponse.setUserCreated(true);
		return createUserResponse;
	}

	@Override
	public void expireUser(ExpireUserRequest expireUserRequest) {
		//get user
		/*
		 * Optional<User> optionaluser =
		 * userRepo.findByIdAndUserName(expireUserRequest.getIntegerCustomerId(),
		 * expireUserRequest.getMUserName());
		 * 
		 * if (!optionaluser.isPresent()) { throw new
		 * RecordNotFound("user does not exist"); }
		 * 
		 * User user = optionaluser.get();
		 * user.setExpireTms(expireUserRequest.getSqlTimestamp());
		 */
		
		//update with expiry time stamp		
		int rowCount=0;
		try {
			 rowCount=userRepo.expireUser(expireUserRequest.getIntegerCustomerId(),
					expireUserRequest.getMUserName(),expireUserRequest.getxpireTimestamp());
			
		} catch (Exception e) {
			
			throw new RecordNotCreated("error in updating user",e);
		}
		
		if(rowCount==0) {
			throw new RecordNotFound("user does not exist");
		}
		log.debug("user deleted successfully");
	}

}
