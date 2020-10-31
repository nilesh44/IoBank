package com.oi.bank.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.oi.bank.repository.PhoneDetailsRepo;


public class isPhonePresentValidator implements ConstraintValidator<IsPhonePresent, String>{
	
	@Autowired
	private PhoneDetailsRepo phoneDetailsRepo;

	@Override
	public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
		if (CollectionUtils.isEmpty(phoneDetailsRepo.findByMobileNumber(mobileNumber))) {
			return true;
		}
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(mobileNumber+ "  :  alrady present").addConstraintViolation();
		return false;
	}

}
