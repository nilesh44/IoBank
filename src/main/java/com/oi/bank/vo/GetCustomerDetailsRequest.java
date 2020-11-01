package com.oi.bank.vo;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class GetCustomerDetailsRequest {
	
	@JsonProperty(value="customerId")
	@NotEmpty(message="provide customerId ")
	private String customerId;

}
