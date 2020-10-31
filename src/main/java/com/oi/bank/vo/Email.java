package com.oi.bank.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.Validation.IsEmailPresent;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Email {

	@JsonProperty(value = "MemailAddress ")
	@NotBlank(message="provide MemailAddress")
	@IsEmailPresent
	@javax.validation.constraints.Email
	private String MemailAddress;

	@JsonProperty(value = "isPreffered ")
	private String isPreffered;
}
