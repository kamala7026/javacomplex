package com.adeptpros.digipass.beans;

public class UserLogin {
	
private String userName;
private String password;
private String loginTime;
private String loginStatus;
private long userId;
private String name;
private long roleId;
private String companyName;



public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public long getRoleId() {
	return roleId;
}
public void setRoleId(long roleId) {
	this.roleId = roleId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getLoginTime() {
	return loginTime;
}
public void setLoginTime(String loginTime) {
	this.loginTime = loginTime;
}

public String getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(String loginStatus) {
	this.loginStatus = loginStatus;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "UserLogin [userName=" + userName + ", password=" + password + ", loginTime=" + loginTime + ", loginStatus="
			+ loginStatus + ", userId=" + userId + ", name=" + name + "]";
}


}
