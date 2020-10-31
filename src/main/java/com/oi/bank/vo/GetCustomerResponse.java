package com.oi.bank.vo;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCustomerResponse {
	@JsonProperty(value="mFirstName")
	private String mFirstName;

	@JsonProperty(value="mLastname")
	private String mLastname;

	@JsonProperty(value="mDateOfBirth")
	private String mDateOfBirth;
	
	@JsonProperty(value="mAadharNumber")
	private String mAadharNumber;
	
	@JsonProperty(value="mPanCardNumber")
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
