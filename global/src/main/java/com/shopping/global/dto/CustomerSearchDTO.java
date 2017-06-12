package com.shopping.global.dto;

import java.io.Serializable;

public class CustomerSearchDTO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 3479999047922092878L;

	private String customerId;

	private String godownNo;

	private String name;
	private String email;
	private String address;
	private String state;
	private String city;
	private String mobile;
	private String landline;
	private String sphone;
	private String dob;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "CustomerSearchDTO [customerId=" + customerId + ", godownNo=" + godownNo + ", mobile=" + mobile
				+ ", name=" + name + "]";
	}

}
