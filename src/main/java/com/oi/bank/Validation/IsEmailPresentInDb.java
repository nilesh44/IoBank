package com.oi.bank.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsEmailPresentValidator.class)
@Documented
public @interface IsEmailPresentInDb {
	
	   public String message() default "email alrady present";
	   
	   public boolean isBlank();

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};


}
