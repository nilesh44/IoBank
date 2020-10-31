package com.oi.bank.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oi.bank.entity.CustomerDetails;

@Repository
@EntityScan(basePackages = "com.oi.bank.entity")
public interface CustomersDetailRepo extends CrudRepository<CustomerDetails, Integer>  {

}
