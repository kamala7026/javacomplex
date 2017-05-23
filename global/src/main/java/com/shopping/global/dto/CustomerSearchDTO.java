package com.shopping.global.dto;

import java.io.Serializable;

public class CustomerSearchDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3479999047922092878L;

	private String customerId;

	private String godownNo;

	private String mobile;

	private String name;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGodownNo() {
		return godownNo;
	}

	public void setGodownNo(String godownNo) {
		this.godownNo = godownNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerSearchDTO [customerId=" + customerId + ", godownNo=" + godownNo + ", mobile=" + mobile
				+ ", name=" + name + "]";
	}
	
}
