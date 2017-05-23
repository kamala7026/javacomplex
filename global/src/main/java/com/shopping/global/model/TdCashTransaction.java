package com.shopping.global.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the td_cash_transaction database table.
 * 
 */
@Entity
@Table(name="td_cash_transaction")
@NamedQuery(name="TdCashTransaction.findAll", query="SELECT t FROM TdCashTransaction t")
public class TdCashTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cash_record_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger cashRecordId;

	private double amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cash_record_date")
	private Date cashRecordDate;

	@Column(name="customer_id")
	private BigInteger customerId;

	@Column(name="goddown_no")
	private String goddownNo;

	private String name;

	private String paymentType;

	public TdCashTransaction() {
	}

	public BigInteger getCashRecordId() {
		return cashRecordId;
	}

	public void setCashRecordId(BigInteger cashRecordId) {
		this.cashRecordId = cashRecordId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCashRecordDate() {
		return this.cashRecordDate;
	}

	public void setCashRecordDate(Date cashRecordDate) {
		this.cashRecordDate = cashRecordDate;
	}

	public BigInteger getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public String getGoddownNo() {
		return this.goddownNo;
	}

	public void setGoddownNo(String goddownNo) {
		this.goddownNo = goddownNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}