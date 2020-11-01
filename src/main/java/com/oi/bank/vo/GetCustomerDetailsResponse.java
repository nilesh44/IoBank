package com.oi.bank.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.entity.CustomerDetails;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class GetCustomerDetailsResponse {
	
	@JsonProperty(value="mFirstName")
	private String mFirstName;

	@JsonProperty(value="mLastname")
	private String mLastname;

	@JsonProperty(value="mDateOfBirth")
	private String mDateOfBirth;
	
	@JsonProperty(value="mIdentityCards")
	GovermentIdentityCards mIdentityCards;

	@JsonProperty(value="mPhones")
	private List<Phone> mPhones;
	
	@JsonProperty(value="emails")
	private List<Email> emails;
	
	@JsonProperty(value="mpostalAddresses")
	private List<PostalAddress> mPostalAddresses;
	
	public static GetCustomerDetailsResponse from(CustomerDetails customerDetails) {
		GetCustomerDetailsResponse response= new GetCustomerDetailsResponse();
		response.setMFirstName(customerDetails.getFirstName());
		response.setMLastname(customerDetails.getLastname());
		response.setMDateOfBirth(customerDetails.getDateOfBirth().toString());
		response.setMIdentityCards(GovermentIdentityCards.from(customerDetails));	
		return response;
	}
}
