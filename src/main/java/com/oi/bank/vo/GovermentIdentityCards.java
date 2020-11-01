package com.oi.bank.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.entity.CustomerDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GovermentIdentityCards {

	@JsonProperty(value = "mAadharNumber")
	private String mAadharNumber;

	@JsonProperty(value = "panCardNumber")
	private String panCardNumber;

	@JsonProperty(value = "driveingLicenceNumber")
	private String driveingLicenceNumber;

	@JsonProperty(value = "pasportNumber")
	private String pasportNumber;

	public static GovermentIdentityCards from(CustomerDetails customerDetails) {
		return GovermentIdentityCards.builder().mAadharNumber(customerDetails.getAadharNumber())
				.panCardNumber(customerDetails.getPanCardnumber()).build();
	}

}
