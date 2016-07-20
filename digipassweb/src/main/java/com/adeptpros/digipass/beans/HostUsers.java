package com.adeptpros.digipass.beans;

import java.util.Arrays;

public class HostUsers implements Comparable<HostUsers>{
	private Long hostUserIdList[];
	private long hostUserId;
	private String firstName="";
	private String lastName="";
	private String email1="";
	private String email2="";
	private String phoneNo1="";
	private String phoneNo2="";
	private String addressLine1="";
	private String addressLine2="";
	private String city="";
	private String district="";
	private String state="";
	private String country="";
	private String pincode="";
	private String expiredDate="";
	private String estateName="";
	private String estateAddress1="";
	private String estateAddress2="";
	private String estateCity="";
	private String estateDistrict="";
	private String estateState="";
	private String estatePincode="";
	private String estateEmail;
	private String estateMobileNo;
	private String status="";
	private String userName="";
	private String userStatus;
	private String grandAccess;
	private String validFrom;
	private String createdDate;
	private String buidingNo;
	private String activeStatus;
	private String userType;
	private String action;
	private String expiredTime;
	private String department;
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long[] getHostUserIdList() {
		return hostUserIdList;
	}
	public void setHostUserIdList(Long[] hostUserIdList) {
		this.hostUserIdList = hostUserIdList;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public long getHostUserId() {
		return hostUserId;
	}
	public void setHostUserId(long hostUserId) {
		this.hostUserId = hostUserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getPhoneNo1() {
		return phoneNo1;
	}
	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}
	public String getPhoneNo2() {
		return phoneNo2;
	}
	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public String getEstateAddress1() {
		return estateAddress1;
	}
	public void setEstateAddress1(String estateAddress1) {
		this.estateAddress1 = estateAddress1;
	}
	public String getEstateAddress2() {
		return estateAddress2;
	}
	public void setEstateAddress2(String estateAddress2) {
		this.estateAddress2 = estateAddress2;
	}
	public String getEstateCity() {
		return estateCity;
	}
	public void setEstateCity(String estateCity) {
		this.estateCity = estateCity;
	}
	public String getEstateDistrict() {
		return estateDistrict;
	}
	public void setEstateDistrict(String estateDistrict) {
		this.estateDistrict = estateDistrict;
	}
	public String getEstateState() {
		return estateState;
	}
	public void setEstateState(String estateState) {
		this.estateState = estateState;
	}
	public String getEstatePincode() {
		return estatePincode;
	}
	public void setEstatePincode(String estatePincode) {
		this.estatePincode = estatePincode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getGrandAccess() {
		return grandAccess;
	}
	public void setGrandAccess(String grandAccess) {
		this.grandAccess = grandAccess;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	public String getBuidingNo() {
		return buidingNo;
	}
	public void setBuidingNo(String buidingNo) {
		this.buidingNo = buidingNo;
	}
	
	
	public String getExpiredTime() {
		return expiredTime;
	}
	public void setExpiredTime(String expiredTime) {
		this.expiredTime = expiredTime;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEstateEmail() {
		return estateEmail;
	}
	public void setEstateEmail(String estateEmail) {
		this.estateEmail = estateEmail;
	}
	public String getEstateMobileNo() {
		return estateMobileNo;
	}
	public void setEstateMobileNo(String estateMobileNo) {
		this.estateMobileNo = estateMobileNo;
	}
	@Override
	public String toString() {
		return "HostUsers [hostUserIdList=" + Arrays.toString(hostUserIdList) + ", hostUserId=" + hostUserId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email1=" + email1 + ", email2=" + email2
				+ ", phoneNo1=" + phoneNo1 + ", phoneNo2=" + phoneNo2 + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + ", expiredDate=" + expiredDate + ", estateName="
				+ estateName + ", estateAddress1=" + estateAddress1 + ", estateAddress2=" + estateAddress2
				+ ", estateCity=" + estateCity + ", estateDistrict=" + estateDistrict + ", estateState=" + estateState
				+ ", estatePincode=" + estatePincode + ", estateEmail=" + estateEmail + ", estateMobileNo="
				+ estateMobileNo + ", status=" + status + ", userName=" + userName + ", userStatus=" + userStatus
				+ ", grandAccess=" + grandAccess + ", validFrom=" + validFrom + ", createdDate=" + createdDate
				+ ", buidingNo=" + buidingNo + ", activeStatus=" + activeStatus + ", userType=" + userType + ", action="
				+ action + ", expiredTime=" + expiredTime + "]";
	}
	@Override
	public int compareTo(HostUsers o) {
		int s=0;
		if(this.getHostUserId()>o.getHostUserId())
			s=-1;

		if(this.getHostUserId()<o.getHostUserId())
			s=1;
		
		if(this.getHostUserId()==o.getHostUserId())
			s=0;
		return s;
		
	}
	
}
