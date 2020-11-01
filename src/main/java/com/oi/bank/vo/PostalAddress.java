package com.oi.bank.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oi.bank.entity.PostalAddressDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PostalAddress {

	@JsonProperty(value = "Mcountry")
	@NotBlank(message = "provide Mcountry")
	private String Mcountry;

	@JsonProperty(value = "Mstate")
	@NotBlank(message = "provide Mstate")
	private String Mstate;

	@JsonProperty(value = "Mpincode")
	@NotBlank(message = "provide Mpincode")
	private String Mpincode;

	@JsonProperty(value = "MpostalAddres")
	@NotBlank(message = "provide MpostalAddres")
	private String MpostalAddres;

	@JsonProperty(value = "isPreffered")
	private String isPreffered;

	public static PostalAddress from(PostalAddressDetails addressDetails) {
		return PostalAddress
				.builder()
				.Mcountry(addressDetails.getCountry())
				.Mstate(addressDetails.getState())
				.Mpincode(addressDetails.getPincode())
				.MpostalAddres(addressDetails.getPostalAddress())
				.isPreffered(addressDetails.getIsPreffered())
				.build();

	}

}
