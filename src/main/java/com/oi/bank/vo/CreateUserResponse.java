package com.oi.bank.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class CreateUserResponse {
	
	@JsonProperty(value="isUserCreated")
	private boolean isUserCreated ;

}
