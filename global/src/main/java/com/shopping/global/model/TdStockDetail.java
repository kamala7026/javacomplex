package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the td_stock_details database table.
 * 
 */
@Entity
@Table(name="td_stock_details")
@NamedQuery(name="TdStockDetail.findAll", query="SELECT t FROM TdStockDetail t")
public class TdStockDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private String product_desc;
	@Id
	@Column(name="product_id")
	private BigInteger productId;

	@Column(name="product_name")
	private String productName;

	public TdStockDetail() {
	}

	public String getProduct_desc() {
		return this.product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public BigInteger getProductId() {
		return this.productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}