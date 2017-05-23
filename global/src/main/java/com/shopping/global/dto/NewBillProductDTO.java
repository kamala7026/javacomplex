package com.shopping.global.dto;


import java.io.Serializable;
import java.math.BigInteger;

public class NewBillProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -75532315075046164L;


	private String batchNumber;

	private String expDate;

	private String productId;

	private String mfgDate;

	private double price;

	private Integer quantity;

	private double sellvat;

	private double totalPrice;

	private String pdesc;

	private String productName;


	@Override
	public String toString() {
		return "NewBillProductDTO [batchNumber=" + batchNumber + ", expDate=" + expDate + ", productId=" + productId
				+ ", mfgDate=" + mfgDate + ", price=" + price + ", quantity=" + quantity + ", sellvat=" + sellvat
				+ ", totalPrice=" + totalPrice + ", pdesc=" + pdesc + ", productName=" + productName + "]";
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getSellvat() {
		return sellvat;
	}

	public void setSellvat(double sellvat) {
		this.sellvat = sellvat;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


}