package com.shopping.global.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the td_user_log database table.
 * 
 */
@Entity
@Table(name="td_user_log")
@NamedQuery(name="TdUserLog.findAll", query="SELECT t FROM TdUserLog t")
public class TdUserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger user_track_id;

	@Column(name="ip_address")
	private String ipAddress;

	@Column(name="loggin_date")
	private Timestamp logginDate;

	@Column(name="session_id")
	private String sessionId;

	@Column(name="shop_id")
	private String shopId;

	@Column(name="user_id")
	private String userId;

	@Column(name="logedout_date")
	private Timestamp loggedOutDate;
	
	
	public Timestamp getLoggedOutDate() {
		return loggedOutDate;
	}


	public void setLoggedOutDate(Timestamp loggedOutDate) {
		this.loggedOutDate = loggedOutDate;
	}


	public TdUserLog() {
	}


	public BigInteger getUser_track_id() {
		return user_track_id;
	}



	public void setUser_track_id(BigInteger user_track_id) {
		this.user_track_id = user_track_id;
	}



	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Timestamp getLogginDate() {
		return this.logginDate;
	}

	public void setLogginDate(Timestamp logginDate) {
		this.logginDate = logginDate;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}