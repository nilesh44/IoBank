package com.oi.bank.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.oi.bank.util.DataTimeUtility;
import com.oi.bank.vo.CreateCustomerDetailsRequest;
import com.oi.bank.vo.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="phone_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phone_id ")
	private int phoneId;

	@Column(name = "cust_id")
	private int customerId;
	
	@Column(name = "cntry_code ")
	private String countryCode;
	
	@Column(name = "mob_no ")
	private String mobileNumber;

	@Column(name = "is_Preffered")
	private String isPreffered;

	@Column(name = "crt_tms")
	private Timestamp createTimestamp;

	@Column(name = "exp_tms")
	private Timestamp expiredTimestamp;
	

	public static PhoneDetails from(int customerId,Phone phone, String createTms) {
		return PhoneDetails
				.builder()
				.customerId(customerId)
				.mobileNumber(phone.getMPhoneNumber())
				.countryCode(StringUtils.trimToNull(phone.getCountryCode()))
				.isPreffered(StringUtils.trimToNull(phone.getIsPreffered()))
				.createTimestamp(DataTimeUtility.getSqlTimeStamp(createTms))
				.build();
	}

	public static List<PhoneDetails> from(CreateCustomerDetailsRequest request,int customerId) {
		return request
				.getMPhones()
				.stream()
				.map(phone -> from(customerId,phone, request.getCreateTimestamp()))
				.collect(Collectors.toList());

	}
}
