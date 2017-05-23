package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the td_customer_balance database table.
 * 
 */
@Entity
@Table(name="td_customer_balance")
@NamedQuery(name="TdCustomerBalance.findAll", query="SELECT t FROM TdCustomerBalance t")
public class TdCustomerBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private BigInteger customerId;

	private String godownno;

	private String name;

	@Column(name="total_balance")
	private double totalBalance;

	public TdCustomerBalance() {

	}



	public BigInteger getCustomerId() {
		return customerId;
	}



	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}



	public String getGodownno() {
		return this.godownno;
	}

	public void setGodownno(String godownno) {
		this.godownno = godownno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalBalance() {
		return this.totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

}