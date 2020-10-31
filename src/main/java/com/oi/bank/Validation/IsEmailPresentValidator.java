package com.oi.bank.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.oi.bank.repository.EmailDetailsRepo;

public class IsEmailPresentValidator implements ConstraintValidator<IsEmailPresent, String>{

	@Autowired
	private EmailDetailsRepo emailDetailsRepo;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (CollectionUtils.isEmpty(emailDetailsRepo.findByEmailAddress(email))) {		
			return true;
		}
		
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(email+ "  :  alrady present").addConstraintViolation();
		return false;
	}

}
