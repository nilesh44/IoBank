package com.oi.bank.service;

import com.oi.bank.vo.CreateCustomerDetailsRequest;
import com.oi.bank.vo.CreateCustomerDetailsResponse;
import com.oi.bank.vo.GetCustomerDetailsRequest;
import com.oi.bank.vo.GetCustomerDetailsResponse;

public interface CustomerDetailsService {

	public CreateCustomerDetailsResponse createCustomer(CreateCustomerDetailsRequest request);

	public GetCustomerDetailsResponse getCustomer(GetCustomerDetailsRequest request);

}
