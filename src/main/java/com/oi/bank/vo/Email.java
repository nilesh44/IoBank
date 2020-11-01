package com.oi.bank.vo;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.Validation.IsEmailPresentInDb;
import com.oi.bank.entity.EmailDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {

	@JsonProperty(value = "emailAddress ")
	@IsEmailPresentInDb(isBlank=false)
	@NotEmpty(message="please provide email address")
	@javax.validation.constraints.Email(message="invalid email address")
	private String MemailAddress;

	@JsonProperty(value = "isPreffered ")
	private String isPreffered;
	
	public static Email from(EmailDetails emailDetails) {
	return	Email.builder()
			.MemailAddress(emailDetails.getEmailAddress())
			.isPreffered(emailDetails.getIsPreffered())
			.build();
	}
}
