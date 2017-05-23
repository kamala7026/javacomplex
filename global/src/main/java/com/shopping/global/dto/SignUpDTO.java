package com.shopping.global.dto;

import java.io.Serializable;

public class SignUpDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4488837235099559986L;
	private String userName;
	private String password;
	private String confirmPassword;
	private String status;
	private String email;
	private String userRole;
	private String shopId;
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getShopId() {
		return shopId;
	}


	public void setShopId(String shopId) {
		this.shopId = shopId;
	}


	@Override
	public String toString() {
		return "SignUpDTO [userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", status=" + status + ", email=" + email + ", userRole=" + userRole + ", shopId=" + shopId + "]";
	}
	
	
	

}
