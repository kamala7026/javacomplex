package com.shopping.global.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the td_customer_search database table.
 * 
 */
@Entity
@Table(name="td_customer_search")
@NamedQuery(name="TdCustomerSearch.findAll", query="SELECT t FROM TdCustomerSearch t")
public class TdCustomerSearch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private String customerId;

	@Column(name="godown_no")
	private String godownNo;

	private String mobile;

	private String name;

	public TdCustomerSearch() {
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGodownNo() {
		return this.godownNo;
	}

	public void setGodownNo(String godownNo) {
		this.godownNo = godownNo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}