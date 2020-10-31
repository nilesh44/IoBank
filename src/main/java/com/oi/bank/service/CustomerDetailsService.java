package com.oi.bank.service;

import org.springframework.stereotype.Service;

import com.oi.bank.vo.CreateCustomerDetailsRequest;
import com.oi.bank.vo.CreateCustomerDetailsResponse;

public interface CustomerDetailsService {
	
	public CreateCustomerDetailsResponse createCustomer(CreateCustomerDetailsRequest request);

}
