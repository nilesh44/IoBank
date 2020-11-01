package com.oi.bank.vo;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.Validation.DateFormate;
import com.oi.bank.util.DataTimeUtility;

import lombok.Data;

@Data
public class ExpireUserRequest {

	@JsonProperty(value = "customerId")
	private int mCustomerId;

	@JsonProperty(value = "userName")
	@NotBlank(message = "provide userName")
	@Size(min = 5, max = 20, message = "length should be in between 5 to 20")
	private String mUserName;

	@JsonProperty(value = "expireTimestamp")
	@DateFormate
	private String expireTimestamp;

	@JsonIgnore
	public Timestamp getxpireTimestamp() {
		return DataTimeUtility.getSqlTimeStamp(expireTimestamp);
	}
	
	@JsonIgnore
	public Integer getIntegerCustomerId() {
		return new Integer(mCustomerId);
	}
}
