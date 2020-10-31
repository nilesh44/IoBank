package com.oi.bank.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oi.bank.entity.CustomerDetails;
import com.oi.bank.entity.EmailDetails;
import com.oi.bank.entity.PhoneDetails;
import com.oi.bank.entity.PostalAddressDetails;
import com.oi.bank.exception.RecordNotCreated;
import com.oi.bank.exception.RecordNotFound;
import com.oi.bank.repository.CustomersDetailRepo;
import com.oi.bank.repository.EmailDetailsRepo;
import com.oi.bank.repository.PhoneDetailsRepo;
import com.oi.bank.repository.PostalAddressDetailsRepo;
import com.oi.bank.service.CustomerDetailsService;
import com.oi.bank.vo.CreateCustomerDetailsRequest;
import com.oi.bank.vo.CreateCustomerDetailsResponse;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private PhoneDetailsRepo phoneDetailsRepo;

	@Autowired
	private PostalAddressDetailsRepo postalAddressDetailsRepo;

	@Autowired
	private EmailDetailsRepo emailDetailsRepo;

	@Autowired
	private CustomersDetailRepo customersDetailRepo;

	@Override
	public CreateCustomerDetailsResponse createCustomer(CreateCustomerDetailsRequest request) {

		// create customer personsal info
		try {
			CustomerDetails customerDetails = CustomerDetails.from(request);
			CustomerDetails customerDetailsDb = customersDetailRepo.save(customerDetails);

			// create customer phone
			List<PhoneDetails> phoneDetails = PhoneDetails.from(request, customerDetailsDb.getCustomerId());
			phoneDetailsRepo.saveAll(phoneDetails);

			// create customer email
			List<EmailDetails> emailDetails = EmailDetails.from(customerDetailsDb.getCustomerId(), request);
			emailDetailsRepo.saveAll(emailDetails);

			// create customer postal address
			List<PostalAddressDetails> postalAddressDetails = PostalAddressDetails
					.from(customerDetailsDb.getCustomerId(), request);
			postalAddressDetailsRepo.saveAll(postalAddressDetails);
		} catch (Exception e) {
			throw new RecordNotCreated("customer record cannot create");
		}
		return CreateCustomerDetailsResponse.builder().isCustomerCreated(true).build();
	}
	
	
	public void getCustomer(String customerId) {
		Optional<CustomerDetails> customerDetailsDb = customersDetailRepo.findById(Integer.parseInt(customerId));
		if(!customerDetailsDb.isPresent()) {
			throw new RecordNotFound("customer not exist");
		}
		
		
		
	}

}
