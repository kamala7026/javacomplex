package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the td_item_details_for_bill database table.
 * 
 */
@Entity
@Table(name="td_item_details_for_return")
@NamedQuery(name="TdItemDetailsForReturn.findAll", query="SELECT t FROM TdItemDetailsForReturn t")
public class TdItemDetailsForReturn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="return_item_details")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger returnItemDetails;

	@Column(name="bill_no")
	private BigInteger billNo;

	@Column(name="product_id")
	private BigInteger productId;

	private Integer quantity;

	@Column(name="sell_price")
	private double sellPrice;

	
	@Column(name="sell_vat")
	private double sellVat;
	
	
	public double getSellVat() {
		return sellVat;
	}


	public void setSellVat(double sellVat) {
		this.sellVat = sellVat;
	}


	public TdItemDetailsForReturn() {
	}




	public BigInteger getReturnItemDetails() {
		return returnItemDetails;
	}


	public void setReturnItemDetails(BigInteger returnItemDetails) {
		this.returnItemDetails = returnItemDetails;
	}




	public BigInteger getBillNo() {
		return this.billNo;
	}

	public void setBillNo(BigInteger billNo) {
		this.billNo = billNo;
	}

	public BigInteger getProductId() {
		return this.productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

}