package com.oi.bank.vo;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostalAddress {

	
	@JsonProperty(value = "Mcountry")
	@NotBlank(message="provide Mcountry")
	private String Mcountry;

	@JsonProperty(value = "Mstate")
	@NotBlank(message="provide Mstate")
	private String Mstate;

	@JsonProperty(value = "Mpincode")
	@NotBlank(message="provide Mpincode")
	private String Mpincode;

	@JsonProperty(value = "MpostalAddres")
	@NotBlank(message="provide MpostalAddres")
	private String MpostalAddres;

	@JsonProperty(value = "isPreffered")
	private String isPreffered;
	
	
	
}
