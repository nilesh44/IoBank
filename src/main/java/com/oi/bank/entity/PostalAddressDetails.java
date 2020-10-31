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
import com.oi.bank.vo.PostalAddress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postal_address_details")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostalAddressDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postal_address_id ")
	private int postalAddresId;

	@Column(name = "cust_id")
	private int customerId;

	@Column(name = "country ")
	private String country;

	@Column(name = "state ")
	private String state;

	@Column(name = "pincode ")
	private String pincode;

	@Column(name = "postal_address ")
	private String postalAddress;

	@Column(name = "is_Preffered")
	private String isPreffered;

	@Column(name = "crt_tms")
	private Timestamp createTimestamp;

	@Column(name = "exp_tms")
	private Timestamp expiredTimestamp;
	
	public static PostalAddressDetails from(int customerId,PostalAddress postalAddress, String createTms) {
		return PostalAddressDetails
				.builder()
				.customerId(customerId)
				.country(postalAddress.getMcountry())
				.state(postalAddress.getMstate())
				.pincode(postalAddress.getMpincode())
				.postalAddress(postalAddress.getMpostalAddres())
				.isPreffered(StringUtils.trimToNull(postalAddress.getIsPreffered()))
				.createTimestamp(DataTimeUtility.getSqlTimeStamp(createTms))
				.build();
	}

	public static List<PostalAddressDetails> from(int customerId,CreateCustomerDetailsRequest request) {
		return request
				.getMPostalAddresses()
				.stream()
				.map(address -> from(customerId,address, request.getCreateTimestamp()))
				.collect(Collectors.toList());

	}
}
