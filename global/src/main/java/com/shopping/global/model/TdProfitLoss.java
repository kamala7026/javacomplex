package com.shopping.global.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the td_profit_loss database table.
 * 
 */
@Entity
@Table(name="td_profit_loss")
@NamedQuery(name="TdProfitLoss.findAll", query="SELECT t FROM TdProfitLoss t")
public class TdProfitLoss implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date day;


	private double amount;

	public TdProfitLoss() {

	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



}