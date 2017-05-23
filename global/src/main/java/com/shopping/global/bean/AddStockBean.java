package com.shopping.global.bean;

import java.io.Serializable;

public class AddStockBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9055239131419583263L;
	
	private String productName;
	private String productDescription;
	private String quantity;
	private String batch;
	private String mfgdate;
	private String expdate;
	private String purchasePrice;
	private String purchaseVat;
	private String sellingPrice;
	private String sellingVat;
	private String productLocation;
	private String productExtraInfo;
	private String productId;
	
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getMfgdate() {
		return mfgdate;
	}

	public void setMfgdate(String mfgdate) {
		this.mfgdate = mfgdate;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getPurchaseVat() {
		return purchaseVat;
	}

	public void setPurchaseVat(String purchaseVat) {
		this.purchaseVat = purchaseVat;
	}

	public String getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getSellingVat() {
		return sellingVat;
	}

	public void setSellingVat(String sellingVat) {
		this.sellingVat = sellingVat;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public String getProductExtraInfo() {
		return productExtraInfo;
	}

	public void setProductExtraInfo(String productExtraInfo) {
		this.productExtraInfo = productExtraInfo;
	}

	@Override
	public String toString() {
		return "AddStockBean [productName=" + productName + ", productDescription=" + productDescription + ", quantity="
				+ quantity + ", batch=" + batch + ", mfgdate=" + mfgdate + ", expdate=" + expdate + ", purchasePrice="
				+ purchasePrice + ", purchaseVat=" + purchaseVat + ", sellingPrice=" + sellingPrice + ", sellingVat="
				+ sellingVat + ", productLocation=" + productLocation + ", productExtraInfo=" + productExtraInfo
				+ ", productId=" + productId + "]";
	}
	
	

}
