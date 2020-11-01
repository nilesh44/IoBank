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
@Constraint(validatedBy = isPhonePresentValidator.class)
@Documented
public @interface IsPhonePresentInDb {
	
	   public String message() default "phone alrady present";

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};

}
