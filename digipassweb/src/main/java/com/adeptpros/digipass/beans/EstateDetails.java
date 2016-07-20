package com.adeptpros.digipass.beans;

public class EstateDetails {
	private String estateName;
	private String estateTitle;
	private String estateAddress;
	private String estateCity;
	private String estateDistrict;
	private String estateState;
	private String estateCountry;
	private String estatePincode;
	private String estateType;
	private int entryPoints;
	private int existPoints;
	private long estateId;
	private String accountManager;
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public String getEstateTitle() {
		return estateTitle;
	}
	public void setEstateTitle(String estateTitle) {
		this.estateTitle = estateTitle;
	}
	public String getEstateAddress() {
		return estateAddress;
	}
	public void setEstateAddress(String estateAddress) {
		this.estateAddress = estateAddress;
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
	public String getEstateCountry() {
		return estateCountry;
	}
	public void setEstateCountry(String estateCountry) {
		this.estateCountry = estateCountry;
	}
	public String getEstatePincode() {
		return estatePincode;
	}
	public void setEstatePincode(String estatePincode) {
		this.estatePincode = estatePincode;
	}
	public String getEstateType() {
		return estateType;
	}
	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}
	public int getEntryPoints() {
		return entryPoints;
	}
	public void setEntryPoints(int entryPoints) {
		this.entryPoints = entryPoints;
	}
	public int getExistPoints() {
		return existPoints;
	}
	public void setExistPoints(int existPoints) {
		this.existPoints = existPoints;
	}
	public long getEstateId() {
		return estateId;
	}
	public void setEstateId(long estateId) {
		this.estateId = estateId;
	}
	
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	@Override
	public String toString() {
		return "EstateDetails [estateName=" + estateName + ", estateTitle=" + estateTitle + ", estateAddress="
				+ estateAddress + ", estateCity=" + estateCity + ", estateDistrict=" + estateDistrict + ", estateState="
				+ estateState + ", estateCountry=" + estateCountry + ", estatePincode=" + estatePincode
				+ ", estateType=" + estateType + ", entryPoints=" + entryPoints + ", existPoints=" + existPoints
				+ ", estateId=" + estateId + ", accountManager=" + accountManager + "]";
	}
	

}
