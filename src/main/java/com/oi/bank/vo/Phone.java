package com.oi.bank.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.Validation.IsPhonePresent;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phone {
	
	@JsonProperty(value="mPhoneNumber")
	@NotBlank(message="provide mPhoneNumber")
    @IsPhonePresent
	private String mPhoneNumber;
	
	
	@JsonProperty(value="countryCode")
	private String countryCode;
	
	
	@JsonProperty(value="isPreffered")
	private String isPreffered;

}
