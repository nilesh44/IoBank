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
@Constraint(validatedBy = DateFormateValidator.class)
@Documented
public @interface DateFormate {
	
	 String message() default "Invalid createTimeStamp: provide 13 digit number i.e, unix TimeStamp";

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};

}
