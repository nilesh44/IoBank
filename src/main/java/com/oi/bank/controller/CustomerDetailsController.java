package com.oi.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oi.bank.service.CustomerDetailsService;
import com.oi.bank.vo.CreateCustomerDetailsRequest;
import com.oi.bank.vo.CreateCustomerDetailsResponse;
import com.oi.bank.vo.GetCustomerDetailsRequest;
import com.oi.bank.vo.GetCustomerDetailsResponse;


@RestController
@RequestMapping(value="customer/details")
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@PostMapping(value="create")
	public ResponseEntity<CreateCustomerDetailsResponse> createCustomer(@Valid @RequestBody CreateCustomerDetailsRequest createCustomerDetailsRequest) {
		
		CreateCustomerDetailsResponse response=customerDetailsService.createCustomer(createCustomerDetailsRequest);
		return new ResponseEntity<CreateCustomerDetailsResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping(value="get")
	public ResponseEntity<GetCustomerDetailsResponse> createCustomer(@Valid @RequestBody GetCustomerDetailsRequest getCustomerDetailsRequest) {		
		GetCustomerDetailsResponse response=customerDetailsService.getCustomer(getCustomerDetailsRequest);
		return new ResponseEntity<GetCustomerDetailsResponse>(response,HttpStatus.OK);
	}

}
