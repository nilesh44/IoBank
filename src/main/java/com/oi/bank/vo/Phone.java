package com.oi.bank.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.Validation.IsPhonePresentInDb;
import com.oi.bank.entity.PhoneDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Phone {

	@JsonProperty(value = "mPhoneNumber")
	@NotBlank(message = "provide mPhoneNumber")
	@IsPhonePresentInDb
	@Size(min=10,max=10, message="please provide valid 10 digit phone number")
	private String mPhoneNumber;

	@JsonProperty(value = "countryCode")
	private String countryCode;

	@JsonProperty(value = "isPreffered")
	private String isPreffered;

	public static Phone from(PhoneDetails phoneDetails) {
		return Phone
				.builder()
				.countryCode(phoneDetails.getCountryCode())
				.isPreffered(phoneDetails.getIsPreffered())
				.mPhoneNumber(phoneDetails.getMobileNumber())
				.build();
	}

}
