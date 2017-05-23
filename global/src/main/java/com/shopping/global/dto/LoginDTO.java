package com.shopping.global.dto;

import java.io.Serializable;

import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(value="logInUser")
public class LoginDTO implements Serializable{

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -5773230474408855411L;
	private String userName;
	private String password;
	private String status;
	private String name;
	private String userId;
	private String userRole;
	private String shopId;
	private String sessionId;
	private String clientIp;
	private String userLogInTrackId;
	
	
	
	
	public String getUserLogInTrackId() {
		return userLogInTrackId;
	}
	public void setUserLogInTrackId(String userLogInTrackId) {
		this.userLogInTrackId = userLogInTrackId;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + ", status=" + status + ", name=" + name
				+ ", userId=" + userId + ", userRole=" + userRole + ", shopId=" + shopId + ", sessionId=" + sessionId
				+ ", clientIp=" + clientIp + ", userLogInTrackId=" + userLogInTrackId + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
