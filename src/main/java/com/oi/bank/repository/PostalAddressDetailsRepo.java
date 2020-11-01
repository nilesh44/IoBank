package com.oi.bank.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oi.bank.entity.PostalAddressDetails;

@Repository
@EntityScan(basePackages = "com.oi.bank.entity")
public interface PostalAddressDetailsRepo extends CrudRepository<PostalAddressDetails, Integer>  {
	
	@Query("select pa from PostalAddressDetails pa where pa.customerId= :customerId and pa.expiredTimestamp is null")
	public List<PostalAddressDetails>findByCustomerId(@Param(value = "customerId") int customerId);
	
}
