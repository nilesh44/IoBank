package com.oi.bank.vo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCustomerDetailsRequest {
	
	@JsonProperty(value="mFirstName")
	@NotEmpty(message="please provide first Name")
	private String mFirstName;

	@JsonProperty(value="mLastname")
	@NotEmpty(message="please provide Last Name")
	private String mLastname;

	@JsonProperty(value="mDateOfBirth")
	@NotEmpty(message="please provide date of birth")
	private String mDateOfBirth;
	
	@JsonProperty(value="mAadharNumber")
	@NotEmpty(message="please provide aadhar number")
	private String mAadharNumber;
	
	@JsonProperty(value="mPanCardNumber")
	@NotEmpty(message="please provide PAN number")
	private String mPanCardNumber;

	@JsonProperty(value="mPhones")
	@Valid
	private List<Phone> mPhones;
	
	@JsonProperty(value="emails")
	@Valid
	private List<Email> emails;
	
	@JsonProperty(value="mpostalAddresses")
	private List<PostalAddress> mPostalAddresses;
	
	@JsonProperty(value="createTimestamp")
	private String createTimestamp;

}
