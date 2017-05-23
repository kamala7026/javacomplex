package com.shopping.global.dto;

import java.io.Serializable;

public class PrintCustomerDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4012309740040355602L;
	
	private String customerId;
	private String startDate;
	private String endDate;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "PrintCustomerDetails [customerId=" + customerId + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
}
