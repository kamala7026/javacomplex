package com.shopping.global.dto;

import java.io.Serializable;

public class PasswordChangeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2427778778429454527L;
	private String userName;
	private String newPassword;
	private String confirmPassword;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "PasswordChangeDTO [userName=" + userName + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}


	
	

}
