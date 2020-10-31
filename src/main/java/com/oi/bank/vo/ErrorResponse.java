package com.oi.bank.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
	
	
	
	private Map<String, List<String>> errors;

	


	public ErrorResponse(Map<String, List<String>> errors) {
		this.errors = errors;
	}
}
