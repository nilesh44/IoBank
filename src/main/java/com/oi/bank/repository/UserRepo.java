package com.oi.bank.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oi.bank.entity.User;

@Repository
@EntityScan(basePackages = "com.oi.bank.entity")
public interface UserRepo extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.custId = :customerId and u.username = :userName and u.expireTms is null ")
	public Optional<User> findByIdAndUserName(@Param("customerId") int customerId, @Param("userName") String userName);

	@Modifying
	@Query("update User u set u.expireTms = :expieTms where  u.custId  = :customerId and u.username = :userName  and u.expireTms is null")
	int expireUser(@Param("customerId") int customerId, @Param("userName") String userName,
			@Param("expieTms") Timestamp expieTms);
	

}
