package com.shopping.global.dto;

import java.io.Serializable;

public class CustomerDueDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2657391590092816780L;

	
	private String customerId;

	private String godownno;
	
	private String name;

	private Double totalBalance;

	
	public String getName() {
		return name;
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


	public String getGodownno() {
		return godownno;
	}

	public void setGodownno(String godownno) {
		this.godownno = godownno;
	}


	public Double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "CustomerDueDTO [customerId=" + customerId + ", godownno=" + godownno + ", name=" + name
				+ ", totalBalance=" + totalBalance + "]";
	}

	
	

}
