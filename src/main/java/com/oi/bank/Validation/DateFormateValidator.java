package com.oi.bank.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class DateFormateValidator implements ConstraintValidator<DateFormate, String> {

	@Override
	public boolean isValid(String createTimeStamp, ConstraintValidatorContext context) {

		if (StringUtils.isNotBlank(createTimeStamp)) {
			try {
				Long.parseLong(createTimeStamp);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.parse(createTimeStamp);

			} catch (NumberFormatException e) {
				return false;
			} catch (ParseException e) {
				return false;
			}

		}
		return true;
	}

}
