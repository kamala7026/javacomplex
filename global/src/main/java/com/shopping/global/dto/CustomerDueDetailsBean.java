package com.shopping.global.dto;

import java.io.Serializable;

public class CustomerDueDetailsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2657391590092816780L;

	
	private String customerId;

	private String goddownNo;
	
	private String billNo;

	private String paidAmount;
	
	private String billAmount;
	
	private String dueAmount;
	
	private String name;
	
	private String billDate;
	

	
	public String getName() {
		return name;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGoddownNo() {
		return goddownNo;
	}

	public void setGoddownNo(String goddownNo) {
		this.goddownNo = goddownNo;
	}

	@Override
	public String toString() {
		return "CustomerDueDetailsBean [customerId=" + customerId + ", goddownNo=" + goddownNo + ", billNo=" + billNo
				+ ", paidAmount=" + paidAmount + ", billAmount=" + billAmount + ", dueAmount=" + dueAmount + ", name="
				+ name + ", billDate=" + billDate + "]";
	}


	
	

}
