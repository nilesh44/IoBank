package com.oi.bank.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.oi.bank.repository.EmailDetailsRepo;

public class IsEmailPresentValidator implements ConstraintValidator<IsEmailPresentInDb, String> {

	@Autowired
	private EmailDetailsRepo emailDetailsRepo;

	private IsEmailPresentInDb isEmailPresentInDb;

	@Override
	public void initialize(IsEmailPresentInDb IsEmail) {
		isEmailPresentInDb = IsEmail;
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (isEmailPresentInDb.isBlank() && StringUtils.isBlank(email)) {
			return true;
		}
		if (CollectionUtils.isEmpty(emailDetailsRepo.findByEmailAddress(email))) {
			return true;
		}
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(email + "  :  alrady present").addConstraintViolation();
		return false;
	}

}
