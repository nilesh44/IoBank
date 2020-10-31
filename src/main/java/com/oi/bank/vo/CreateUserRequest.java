package com.oi.bank.vo;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.Validation.DateFormate;

import lombok.Data;

@Data
public class CreateUserRequest {
	
 
	@JsonProperty(value="McustomerId")
	private int McustomerId;
	
	@JsonProperty(value="MuserName")
	@NotBlank(message="provide userName")
	@Size(min=5 , max=20 , message="length should be in between 5 to 20")
	private String MuserName;
	
	@JsonProperty(value="Mpassword")
	@NotBlank(message="provide password")
	@Size(min=5 , max=20 , message="length should be in between 5 to 20")
	private String Mpassword;
	
	@JsonProperty(value="createTime")
	@DateFormate
	private String createTimestamp;

}
