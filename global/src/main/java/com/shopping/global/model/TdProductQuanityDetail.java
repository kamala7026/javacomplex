package com.shopping.global.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the td_product_quanity_details database table.
 * 
 */
@Entity
@Table(name="td_product_quanity_details")
@NamedQuery(name="TdProductQuanityDetail.findAll", query="SELECT t FROM TdProductQuanityDetail t")
public class TdProductQuanityDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger productId;

	@Column(name="product_batch_no")
	private String productBatchNo;

	@Column(name="product_desc")
	private String productDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="product_expiry_dt")
	private Date productExpiryDt;

	@Column(name="product_extra_info")
	private String productExtraInfo;

	@Column(name="product_location")
	private String productLocation;

	@Temporal(TemporalType.DATE)
	@Column(name="product_mfg_dt")
	private Date productMfgDt;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_purchase_price")
	private double productPurchasePrice;

	@Column(name="product_purchase_vat")
	private double productPurchaseVat;

	@Column(name="product_quantity")
	private BigInteger productQuantity;

	@Column(name="product_sell_vat")
	private double productSellVat;

	@Column(name="product_selling_price")
	private double productSellingPrice;

	public TdProductQuanityDetail() {
	}


	public BigInteger getProductId() {
		return productId;
	}


	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}


	public String getProductBatchNo() {
		return this.productBatchNo;
	}

	public void setProductBatchNo(String productBatchNo) {
		this.productBatchNo = productBatchNo;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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