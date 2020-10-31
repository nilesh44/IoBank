package com.oi.bank.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.oi.bank.vo.CommonErrorResponse;
import com.oi.bank.vo.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class BankExceptionHandler {

	@ExceptionHandler(value = RecordNotCreated.class)
	public ResponseEntity<CommonErrorResponse> recordNotCreatedExceptionHandler(RecordNotCreated recordNotCreated) {
		log.error("error while creating user",recordNotCreated);
		return new ResponseEntity<CommonErrorResponse>(new CommonErrorResponse(recordNotCreated.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RecordNotFound.class)
	public ResponseEntity<CommonErrorResponse> recordNotFound(RecordNotFound recordNotFound) {
		log.error("Record not foundr",recordNotFound);
		return new ResponseEntity<CommonErrorResponse>(new CommonErrorResponse(recordNotFound.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidRequestParameterException.class)
	public ResponseEntity<ErrorResponse> InvalidRequestParameterExceptionhandler(InvalidRequestParameterException invalidRequestParameterException) {
		log.error("invalid request Parameter passed",invalidRequestParameterException);
		HashMap< String, String> errors=new HashMap<String, String>();
		errors.put(invalidRequestParameterException.getParameterName(), invalidRequestParameterException.getMessage());
		return new ResponseEntity<ErrorResponse>(
				HttpStatus.BAD_REQUEST);
	}
		
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
		log.error("invalid request Parameter passed",methodArgumentNotValidException);
				
		Map<String, List<String>> errors= new HashMap<String, List<String>>();
			methodArgumentNotValidException
			.getBindingResult()
			.getFieldErrors().stream()
			.forEach(
					error->{
						if(errors.containsKey(error.getField())) {
							errors.get(error.getField()).add(error.getDefaultMessage());						
						}
						else {
							List<String> errorlist=new ArrayList<String>();
							errorlist.add(error.getDefaultMessage());
							errors.put(error.getField(),errorlist);	
						}
						
						
						
					});
			
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(errors),
				HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<CommonErrorResponse> ConstraintViolationExceptionHandler(ConstraintViolationException constraintViolationException) {
		log.error("invalid request Parameter passed",constraintViolationException);
		return new ResponseEntity<CommonErrorResponse>(new CommonErrorResponse(constraintViolationException.getLocalizedMessage()),
				HttpStatus.BAD_REQUEST);
	}

}
