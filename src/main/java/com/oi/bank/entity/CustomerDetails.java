package com.oi.bank.entity;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oi.bank.util.DataTimeUtility;
import com.oi.bank.vo.CreateCustomerDetailsRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id ")
	private int customerId;

	@Column(name = "first_nm")
	private String firstName;

	@Column(name = "last_nm ")
	private String lastname;

	@Column(name = "dob")
	private Date dateOfBirth;

	@Column(name = "aadhar_no ")
	private String aadharNumber;

	@Column(name = "pan_no")
	private String panCardnumber;

	@Column(name = "isblock")
	private char isblock;

	@Column(name = "crt_tms")
	private Timestamp createTimestamp;

	@Column(name = "exp_tms")
	private Timestamp expiredTimestamp;
	
	public static CustomerDetails from(CreateCustomerDetailsRequest request) {
		return CustomerDetails.builder()
		.firstName(request.getMFirstName())
		.lastname(request.getMLastname())
		.aadharNumber(request.getMAadharNumber())
		.panCardnumber(request.getMPanCardNumber())
		.dateOfBirth(new Date(Long.parseLong(request.getMDateOfBirth())))
		.createTimestamp(DataTimeUtility.getSqlTimeStamp(request.getCreateTimestamp()))
		.build();
	}

}
