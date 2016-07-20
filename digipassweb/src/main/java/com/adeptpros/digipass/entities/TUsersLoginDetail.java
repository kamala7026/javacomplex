package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the t_users_login_details database table.
 * 
 */
@Entity
@Table(name="t_users_login_details")
@NamedQuery(name="TUsersLoginDetail.findAll", query="SELECT t FROM TUsersLoginDetail t")
public class TUsersLoginDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long userId;
	
	@Column(name="user_name")
	private String userName;

	@Column(name="active_status")
	private int activeStatus;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_login_time")
	private Timestamp lastLoginTime;

	private String password;	

	//bi-directional many-to-one association to TEstateAdmin
	@OneToOne(mappedBy="TUsersLoginDetail1",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private TEstateAdmin TEstateAdmins1;

	//bi-directional many-to-one association to TEstateAdmin
	@OneToMany(mappedBy="TUsersLoginDetail2")
	private List<TEstateAdmin> TEstateAdmins2;

	//bi-directional many-to-one association to TEstateDetail
	@OneToMany(mappedBy="TUsersLoginDetail")
	private List<TEstateDetail> TEstateDetails;

	//bi-directional many-to-one association to TEstateGateMan
	@OneToOne(mappedBy="TUsersLoginDetail1",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private TEstateGateMan TEstateGateMans1;

	//bi-directional many-to-one association to TEstateGateMan
	@OneToMany(mappedBy="TUsersLoginDetail2")
	private List<TEstateGateMan> TEstateGateMans2;

	

	//bi-directional many-to-one association to TPassDetail
	@OneToMany(mappedBy="TUsersLoginDetail")
	private List<TPassDetail> TPassDetails;

	//bi-directional many-to-one association to TRoleDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	private TRoleDetail TRoleDetail;

	//bi-directional many-to-one association to TUsersLoginDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="created_by")
	private TUsersLoginDetail TUsersLoginDetail;

	//bi-directional many-to-one association to TUsersLoginDetail
	@OneToMany(mappedBy="TUsersLoginDetail")
	private List<TUsersLoginDetail> TUsersLoginDetails;

	//bi-directional many-to-one association to TEstateHost
	@OneToOne(mappedBy="TUsersLoginDetail1",cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private TEstateHost TEstateHosts1;

	//bi-directional many-to-one association to TEstateHost
	@OneToMany(mappedBy="TUsersLoginDetail2")
	private List<TEstateHost> TEstateHosts2;

	public TUsersLoginDetail() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	


	public TEstateAdmin getTEstateAdmins1() {
		return TEstateAdmins1;
	}

	public void setTEstateAdmins1(TEstateAdmin tEstateAdmins1) {
		TEstateAdmins1 = tEstateAdmins1;
	}

	public List<TEstateAdmin> getTEstateAdmins2() {
		return this.TEstateAdmins2;
	}

	public void setTEstateAdmins2(List<TEstateAdmin> TEstateAdmins2) {
		this.TEstateAdmins2 = TEstateAdmins2;
	}

	

	public List<TEstateDetail> getTEstateDetails() {
		return this.TEstateDetails;
	}

	public void setTEstateDetails(List<TEstateDetail> TEstateDetails) {
		this.TEstateDetails = TEstateDetails;
	}

	

	public TEstateGateMan getTEstateGateMans1() {
		return this.TEstateGateMans1;
	}

	public void setTEstateGateMans1(TEstateGateMan TEstateGateMans1) {
		this.TEstateGateMans1 = TEstateGateMans1;
	}

	

	public List<TEstateGateMan> getTEstateGateMans2() {
		return this.TEstateGateMans2;
	}

	public void setTEstateGateMans2(List<TEstateGateMan> TEstateGateMans2) {
		this.TEstateGateMans2 = TEstateGateMans2;
	}

	


	

	public List<TPassDetail> getTPassDetails() {
		return this.TPassDetails;
	}

	public void setTPassDetails(List<TPassDetail> TPassDetails) {
		this.TPassDetails = TPassDetails;
	}


	public TRoleDetail getTRoleDetail() {
		return this.TRoleDetail;
	}

	public void setTRoleDetail(TRoleDetail TRoleDetail) {
		this.TRoleDetail = TRoleDetail;
	}

	public TUsersLoginDetail getTUsersLoginDetail() {
		return this.TUsersLoginDetail;
	}

	public void setTUsersLoginDetail(TUsersLoginDetail TUsersLoginDetail) {
		this.TUsersLoginDetail = TUsersLoginDetail;
	}

	public List<TUsersLoginDetail> getTUsersLoginDetails() {
		return this.TUsersLoginDetails;
	}

	public void setTUsersLoginDetails(List<TUsersLoginDetail> TUsersLoginDetails) {
		this.TUsersLoginDetails = TUsersLoginDetails;
	}

	

	public TEstateHost getTEstateHosts1() {
		return this.TEstateHosts1;
	}

	public void setTEstateHosts1(TEstateHost TEstateHosts1) {
		this.TEstateHosts1 = TEstateHosts1;
	}

	
	public List<TEstateHost> getTEstateHosts2() {
		return this.TEstateHosts2;
	}

	public void setTEstateHosts2(List<TEstateHost> TEstateHosts2) {
		this.TEstateHosts2 = TEstateHosts2;
	}

	
}