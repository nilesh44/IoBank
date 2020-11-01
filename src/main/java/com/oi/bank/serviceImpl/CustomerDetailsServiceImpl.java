package com.oi.bank.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
import com.oi.bank.vo.Email;
import com.oi.bank.vo.GetCustomerDetailsRequest;
import com.oi.bank.vo.GetCustomerDetailsResponse;
import com.oi.bank.vo.Phone;
import com.oi.bank.vo.PostalAddress;

@Service
@Transactional
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
			if(!CollectionUtils.isEmpty(request.getEmails())) {
			List<EmailDetails> emailDetails = EmailDetails.from(customerDetailsDb.getCustomerId(), request);
			emailDetailsRepo.saveAll(emailDetails);
			}
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
		if (!customerDetailsDb.isPresent()) {
			throw new RecordNotFound("customer not exist");
		}

	}

	@Override
	public GetCustomerDetailsResponse getCustomer(GetCustomerDetailsRequest request) {
		int customerId = Integer.parseInt(request.getCustomerId());
		GetCustomerDetailsResponse getCustomerDetailsResponse = getCustomerDetail(customerId);
		getCustomerDetailsResponse.setMPhones(getPhone(customerId));
		getCustomerDetailsResponse.setEmails(getEmail(customerId));
		getCustomerDetailsResponse.setMPostalAddresses(getPostalAddress(customerId));
		return getCustomerDetailsResponse;
	}

	private GetCustomerDetailsResponse getCustomerDetail(int customerId) {
		Optional<CustomerDetails> customerDetails = customersDetailRepo.findById(customerId);
		if (!customerDetails.isPresent()) {
			throw new RecordNotFound("record for given CustomerId is not Present");
		}
		return GetCustomerDetailsResponse.from(customerDetails.get());
	}

	private List<Phone> getPhone(int customerId) {
		List<PhoneDetails> phoneDetails = phoneDetailsRepo.findByCustomerId(customerId);
		List<Phone> phones = new ArrayList<>();
		phoneDetails.stream().forEach(phoneDetail -> {
			Phone phone = Phone.from(phoneDetail);
			phones.add(phone);
		});
		return phones;
	}

	private List<Email> getEmail(int customerId) {
		List<EmailDetails> emailDetails = emailDetailsRepo.findByCustomerId(customerId);
		List<Email> emails = new ArrayList<>();
		emailDetails.stream().forEach(emailDetail -> {
			Email email = Email.from(emailDetail);
			emails.add(email);
		});
		return emails;
	}

	private List<PostalAddress> getPostalAddress(int customerId) {
		List<PostalAddressDetails> postalAddressDetails = postalAddressDetailsRepo.findByCustomerId(customerId);
		List<PostalAddress> PostalAddresses = new ArrayList<>();
		postalAddressDetails.stream().forEach(postalAddressDetail -> {
			PostalAddress postalAddress = PostalAddress.from(postalAddressDetail);
			PostalAddresses.add(postalAddress);
		});
		return PostalAddresses;
	}

}
