package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the t_user_login database table.
 * 
 */
@Entity
@Table(name="t_user_login")
@NamedQuery(name="TUserLogin.findAll", query="SELECT t FROM TUserLogin t")
public class TUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="last_login_time")
	private Timestamp lastLoginTime;

	private String password;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_login_id")
	private BigInteger userLoginId;

	//bi-directional one-to-one association to THostDetail
	@OneToOne
	@JoinColumn(name="user_id")
	private THostDetail THostDetail;

	public TUserLogin() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getUserLoginId() {
		return this.userLoginId;
	}

	public void setUserLoginId(BigInteger userLoginId) {
		this.userLoginId = userLoginId;
	}

	public THostDetail getTHostDetail() {
		return this.THostDetail;
	}

	public void setTHostDetail(THostDetail THostDetail) {
		this.THostDetail = THostDetail;
	}

}