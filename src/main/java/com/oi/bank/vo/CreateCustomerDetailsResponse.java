package com.oi.bank.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerDetailsResponse {
	
	@JsonProperty(value="isCustomerCreated")
	private boolean isCustomerCreated;

}
