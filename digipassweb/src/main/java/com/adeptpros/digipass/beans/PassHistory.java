package com.adeptpros.digipass.beans;

import java.util.Date;

public class PassHistory implements Comparable<PassHistory>{

	private long passId;
	private String createdDate;
	private String visitorAddress;
	private String visitorEmailId;
	private String visitorInstruction;
	private String visitorMobileNo;
	private String visitorFirstName;
	private String visitorLastName;
	private String visitorPassLink;
	private String visitorPassStatus;
	private String visitorStartTime;
	private String visitorVanue;
	private String visitorPurpose;
	private String companyName;
	private String visitorEndTime;
	private String visitorEntryTime;
	private String visitorExitTime;
	private String createdBy;
	private long estateId;
	private String estateName;
	private long hostId;
	private String hostFirstName;
	private String hostLastName;
	private String hostEmail;
	private String hostMobile;
	private String visitorVechilesDetails;
	private String visitorEquipmentDetails;
	private String passStatus;
	private Date fromDate;
	private Date toDate;
	
	
	
	public String getHostEmail() {
		return hostEmail;
	}
	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}
	public String getHostMobile() {
		return hostMobile;
	}
	public void setHostMobile(String hostMobile) {
		this.hostMobile = hostMobile;
	}
	public String getVisitorEntryTime() {
		return visitorEntryTime;
	}
	public void setVisitorEntryTime(String visitorEntryTime) {
		this.visitorEntryTime = visitorEntryTime;
	}
	public String getVisitorExitTime() {
		return visitorExitTime;
	}
	public void setVisitorExitTime(String visitorExitTime) {
		this.visitorExitTime = visitorExitTime;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPassStatus() {
		return passStatus;
	}
	public void setPassStatus(String passStatus) {
		this.passStatus = passStatus;
	}
	public long getPassId() {
		return passId;
	}
	public void setPassId(long passId) {
		this.passId = passId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getVisitorAddress() {
		return visitorAddress;
	}
	public void setVisitorAddress(String visitorAddress) {
		this.visitorAddress = visitorAddress;
	}
	public String getVisitorEmailId() {
		return visitorEmailId;
	}
	public void setVisitorEmailId(String visitorEmailId) {
		this.visitorEmailId = visitorEmailId;
	}
	public String getVisitorInstruction() {
		return visitorInstruction;
	}
	public void setVisitorInstruction(String visitorInstruction) {
		this.visitorInstruction = visitorInstruction;
	}
	
	public String getVisitorMobileNo() {
		return visitorMobileNo;
	}
	public void setVisitorMobileNo(String visitorMobileNo) {
		this.visitorMobileNo = visitorMobileNo;
	}
	public String getVisitorFirstName() {
		return visitorFirstName;
	}
	public void setVisitorFirstName(String visitorFirstName) {
		this.visitorFirstName = visitorFirstName;
	}
	public String getVisitorLastName() {
		return visitorLastName;
	}
	public void setVisitorLastName(String visitorLastName) {
		this.visitorLastName = visitorLastName;
	}
	
	public String getVisitorEquipmentDetails() {
		return visitorEquipmentDetails;
	}
	public void setVisitorEquipmentDetails(String visitorEquipmentDetails) {
		this.visitorEquipmentDetails = visitorEquipmentDetails;
	}
	public String getVisitorPassLink() {
		return visitorPassLink;
	}
	public void setVisitorPassLink(String visitorPassLink) {
		this.visitorPassLink = visitorPassLink;
	}
	public String getVisitorPassStatus() {
		return visitorPassStatus;
	}
	public void setVisitorPassStatus(String visitorPassStatus) {
		this.visitorPassStatus = visitorPassStatus;
	}
	public String getVisitorStartTime() {
		return visitorStartTime;
	}
	public void setVisitorStartTime(String visitorStartTime) {
		this.visitorStartTime = visitorStartTime;
	}
	public String getVisitorEndTime() {
		return visitorEndTime;
	}
	public void setVisitorEndTime(String visitorEndTime) {
		this.visitorEndTime = visitorEndTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public long getEstateId() {
		return estateId;
	}
	public void setEstateId(long estateId) {
		this.estateId = estateId;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	
	public long getHostId() {
		return hostId;
	}
	public void setHostId(long hostId) {
		this.hostId = hostId;
	}
	public String getHostFirstName() {
		return hostFirstName;
	}
	public void setHostFirstName(String hostFirstName) {
		this.hostFirstName = hostFirstName;
	}
	public String getHostLastName() {
		return hostLastName;
	}
	public void setHostLastName(String hostLastName) {
		this.hostLastName = hostLastName;
	}
	public String getVisitorVechilesDetails() {
		return visitorVechilesDetails;
	}
	public void setVisitorVechilesDetails(String visitorVechilesDetails) {
		this.visitorVechilesDetails = visitorVechilesDetails;
	}
	
	
	public String getVisitorVanue() {
		return visitorVanue;
	}
	public void setVisitorVanue(String visitorVanue) {
		this.visitorVanue = visitorVanue;
	}
	public String getVisitorPurpose() {
		return visitorPurpose;
	}
	public void setVisitorPurpose(String visitorPurpose) {
		this.visitorPurpose = visitorPurpose;
	}
	@Override
	public String toString() {
		return "PassHistory [passId=" + passId + ", createdDate=" + createdDate + ", visitorAddress=" + visitorAddress
				+ ", visitorEmailId=" + visitorEmailId + ", visitorInstruction=" + visitorInstruction
				+ ", visitorMobileNo=" + visitorMobileNo + ", visitorFirstName=" + visitorFirstName
				+ ", visitorLastName=" + visitorLastName + ", visitorPassLink=" + visitorPassLink
				+ ", visitorPassStatus=" + visitorPassStatus + ", visitorStartTime=" + visitorStartTime
				+ ", visitorVanue=" + visitorVanue + ", visitorPurpose=" + visitorPurpose + ", companyName="
				+ companyName + ", visitorEndTime=" + visitorEndTime + ", createdBy=" + createdBy + ", estateId="
				+ estateId + ", estateName=" + estateName + ", hostId=" + hostId + ", hostFirstName=" + hostFirstName
				+ ", hostLastName=" + hostLastName + ", visitorVechilesDetails=" + visitorVechilesDetails
				+ ", visitorEquipmentDetails=" + visitorEquipmentDetails + ", passStatus=" + passStatus + "]";
	}
	@Override
	public int compareTo(PassHistory o) {
		if(this.getPassId()>o.getPassId())
			return -1;
		if(this.getPassId()<o.getPassId())
			return 1;
		else
			return 0;
	}
	
	
	
}
