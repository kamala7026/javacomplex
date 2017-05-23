package com.shopping.global.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class StockSearchDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3479999047922092878L;

	private BigInteger productId;

	private String product_desc;

	private String productName;

	
	public BigInteger getProductId() {
		return productId;
	}


	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}


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


	@Override
	public String toString() {
		return "StockSearch [productId=" + productId + ", product_desc=" + product_desc + ", productName=" + productName
				+ "]";
	}
	

	
}
