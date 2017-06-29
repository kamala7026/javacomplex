package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the td_purchase_history database table.
 * 
 */
@Entity
@Table(name="td_return_history")
@NamedQuery(name="TdReturnHistory.findAll", query="SELECT t FROM TdReturnHistory t")
public class TdReturnHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger billNo;

	@Column(name="basic_amount")
	private double basicAmount;

	@Column(name="bill_amount")
	private double billAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="return_date")
	private Date returnDate;

	@Column(name="customer_id")
	private BigInteger customerId;

	@Column(name="return_amount")
	private double returnAmount;

	@Column(name="godown_no")
	private String godownNo;

	@Column(name="paid_amount")
	private double paidAmount;

	@Column(name="payment_type")
	private String paymentType;

	@Column(name="vat_amount")
	private double vatAmount;
	
	@Column(name="processed")
	private String processed;
	

	public TdReturnHistory() {
	}
	

	public String getProcessed() {
		return processed;
	}


	public void setProcessed(String processed) {
		this.processed = processed;
	}


	public BigInteger getBillNo() {
		return billNo;
	}


	public void setBillNo(BigInteger billNo) {
		this.billNo = billNo;
	}


	public double getBasicAmount() {
		return this.basicAmount;
	}

	public void setBasicAmount(double basicAmount) {
		this.basicAmount = basicAmount;
	}

	public double getBillAmount() {
		return this.billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	
	public BigInteger getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	

	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public double getReturnAmount() {
		return returnAmount;
	}


	public void setReturnAmount(double returnAmount) {
		this.returnAmount = returnAmount;
	}


	public String getGodownNo() {
		return this.godownNo;
	}

	public void setGodownNo(String godownNo) {
		this.godownNo = godownNo;
	}

	public double getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

}