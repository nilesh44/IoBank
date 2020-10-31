package com.oi.bank.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oi.bank.util.DataTimeUtility;
import com.oi.bank.vo.CreateUserRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_login_credential")
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 3926486340453091737L;

	////// @EmbeddedId
	// private UserPk userPk;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_cred_id")
	private int loginCredentialId;

	@Column(name = "cust_id")
	private int custId;
	

	@Column(name = "username ")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "crt_tms ")
	private Timestamp createTms;

	@Column(name = "exp_tms")
	private Timestamp expireTms;

	/*
	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "cust_id", nullable = false, insertable = false, updatable
	 * = false) private CustomerDetails customerDetails;
	 */

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "cust_id",insertable=false
	 * ,updatable=false,referencedColumnName="cust_id") private CustomerDetails
	 * customerDetails;
	 */

	public User(CreateUserRequest createUserRequest) {
		super();

		// this.userPk =
		// UserPk.builder().custId(createUserRequest.getMcustomerId()).build();
		this.custId = createUserRequest.getMcustomerId();
		this.username = createUserRequest.getMuserName();
		this.password = createUserRequest.getMpassword();
		this.createTms =DataTimeUtility.getSqlTimeStamp(createUserRequest.getCreateTimestamp());
		// this.customerDetails=CustomerDetails.builder().customerId(createUserRequest.getMcustomerId()).build();
		this.expireTms = null;
	}

}
