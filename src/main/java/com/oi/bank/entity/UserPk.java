package com.oi.bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPk implements Serializable {
	
	private static final long serialVersionUID = 679553496511950161L;
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;

}
