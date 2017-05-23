package com.shopping.global.bean;

import java.io.Serializable;

public class CustomerDetailsBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8399133822363461350L;
	private String name;
	private String   gnumber;
	private String email;
	private String address;
	private String state;
	private String city;
	private String mobile;
	private String landline;
	private String sphone;
	private String dob;
	
	
	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getGnumber() {
		return gnumber;
	}

	public void setGnumber(String gnumber) {
		this.gnumber = gnumber;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobileNumber) {
		this.mobile = mobileNumber;
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
		return "CustomerDetailsBean [name=" + name + ", gnumber=" + gnumber + ", email=" + email + ", address="
				+ address + ", state=" + state + ", city=" + city + ", mobile=" + mobile + ", landline=" + landline
				+ ", sphone=" + sphone + ", dob=" + dob + "]";
	}


	
}
