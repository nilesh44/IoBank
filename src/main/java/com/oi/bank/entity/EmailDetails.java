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

import com.oi.bank.util.DataTimeUtility;
import com.oi.bank.vo.CreateCustomerDetailsRequest;
import com.oi.bank.vo.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id ")
	private int emailId;

	@Column(name = "cust_id")
	private int customerId;

	@Column(name = "email_address ")
	private String emailAddress;

	@Column(name = "is_Preffered")
	private String isPreffered;

	@Column(name = "crt_tms")
	private Timestamp createTimestamp;

	@Column(name = "exp_tms")
	private Timestamp expiredTimestamp;
	

	public static EmailDetails from(int customerId,Email email, String createTms) {
		return EmailDetails
				.builder()
				.customerId(customerId)
				.emailAddress(email.getMemailAddress()).isPreffered(email.getIsPreffered())
				.createTimestamp(DataTimeUtility.getSqlTimeStamp(createTms))
				.build();
	}

	public static List<EmailDetails> from(int customerId,CreateCustomerDetailsRequest request) {
		return request
				.getEmails()
				.stream()
				.map(email -> from(customerId,email, request.getCreateTimestamp()))
				.collect(Collectors.toList());

	}
}
