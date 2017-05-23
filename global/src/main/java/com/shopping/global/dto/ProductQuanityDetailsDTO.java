package com.shopping.global.dto;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ProductQuanityDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -75532315075046164L;

	private BigInteger productIdCode;

	private String productBatchNo;

	private Date productExpiryDt;

	private String productExtraInfo;

	private BigInteger productId;

	private String productLocation;

	private Date productMfgDt;

	private double productPurchasePrice;

	private double productPurchaseVat;

	private BigInteger productQuantity;

	private double productSellVat;

	private double productSellingPrice;

	private String product_desc;

	private String productName;
	
	public String getProduct_desc() {
		return product_desc;
	}


	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public ProductQuanityDetailsDTO() {
	}


	@Override
	public String toString() {
		return "ProductQuanityDetailsDTO [productIdCode=" + productIdCode + ", productBatchNo=" + productBatchNo
				+ ", productExpiryDt=" + productExpiryDt + ", productExtraInfo=" + productExtraInfo + ", productId="
				+ productId + ", productLocation=" + productLocation + ", productMfgDt=" + productMfgDt
				+ ", productPurchasePrice=" + productPurchasePrice + ", productPurchaseVat=" + productPurchaseVat
				+ ", productQuantity=" + productQuantity + ", productSellVat=" + productSellVat
				+ ", productSellingPrice=" + productSellingPrice + ", product_desc=" + product_desc + ", productName="
				+ productName + "]";
	}


	public BigInteger getProductIdCode() {
		return productIdCode;
	}


	public void setProductIdCode(BigInteger productIdCode) {
		this.productIdCode = productIdCode;
	}


	public String getProductBatchNo() {
		return this.productBatchNo;
	}

	public void setProductBatchNo(String productBatchNo) {
		this.productBatchNo = productBatchNo;
	}

	public Date getProductExpiryDt() {
		return this.productExpiryDt;
	}

	public void setProductExpiryDt(Date productExpiryDt) {
		this.productExpiryDt = productExpiryDt;
	}

	public String getProductExtraInfo() {
		return this.productExtraInfo;
	}

	public void setProductExtraInfo(String productExtraInfo) {
		this.productExtraInfo = productExtraInfo;
	}

	public BigInteger getProductId() {
		return this.productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public String getProductLocation() {
		return this.productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public Date getProductMfgDt() {
		return this.productMfgDt;
	}

	public void setProductMfgDt(Date productMfgDt) {
		this.productMfgDt = productMfgDt;
	}

	public double getProductPurchasePrice() {
		return this.productPurchasePrice;
	}

	public void setProductPurchasePrice(double productPurchasePrice) {
		this.productPurchasePrice = productPurchasePrice;
	}

	public double getProductPurchaseVat() {
		return this.productPurchaseVat;
	}

	public void setProductPurchaseVat(double productPurchaseVat) {
		this.productPurchaseVat = productPurchaseVat;
	}

	public BigInteger getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(BigInteger productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductSellVat() {
		return this.productSellVat;
	}

	public void setProductSellVat(double productSellVat) {
		this.productSellVat = productSellVat;
	}

	public double getProductSellingPrice() {
		return this.productSellingPrice;
	}

	public void setProductSellingPrice(double productSellingPrice) {
		this.productSellingPrice = productSellingPrice;
	}

}