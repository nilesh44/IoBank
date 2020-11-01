package com.oi.bank.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oi.bank.entity.EmailDetails;

@Repository
@EntityScan(basePackages = "com.oi.bank.entity")
public interface EmailDetailsRepo extends CrudRepository<EmailDetails, Integer>  {
	
	@Query("select e from EmailDetails e where e.customerId= :customerId and e.expiredTimestamp is null")
	public List<EmailDetails>findByCustomerId(@Param(value = "customerId") int customerId);
	
	@Query("select e from EmailDetails e where e.emailAddress= :emailAddress and e.expiredTimestamp is null")
	public List<EmailDetails> findByEmailAddress(@Param(value= "emailAddress") String emailAddress);
}
