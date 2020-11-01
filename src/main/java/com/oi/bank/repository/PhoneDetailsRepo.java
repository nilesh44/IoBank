package com.oi.bank.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oi.bank.entity.PhoneDetails;

@Repository
@EntityScan(basePackages = "com.oi.bank.entity")
public interface PhoneDetailsRepo  extends CrudRepository<PhoneDetails, Integer>  {
	
	
	@Query("select p from PhoneDetails p where p.customerId= :customerId and p.expiredTimestamp is null")
	public List<PhoneDetails>findByCustomerId(@Param(value = "customerId") int customerId);
	
	@Query("select p from PhoneDetails p where p.mobileNumber= :mobileNumber and p.expiredTimestamp is null")
	public List<PhoneDetails> findByMobileNumber(@Param(value= "mobileNumber") String mobileNumber);

}
