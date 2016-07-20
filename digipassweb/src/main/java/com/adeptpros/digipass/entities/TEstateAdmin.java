package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_estate_admin database table.
 * 
 */
@Entity
@Table(name="t_estate_admin")
@NamedQuery(name="TEstateAdmin.findAll", query="SELECT t FROM TEstateAdmin t")
public class TEstateAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="e_admin_id")
	private long eAdminId;

	@Column(name="active_status")
	private int activeStatus;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="e_admin_address1")
	private String eAdminAddress1;
	
	@Column(name="e_admin_address2")
	private String eAdminAddress2;

	@Column(name="e_admin_city")
	private String eAdminCity;

	@Column(name="e_admin_country")
	private String eAdminCountry;

	@Column(name="e_admin_district")
	private String eAdminDistrict;

	@Column(name="e_admin_email")
	private String eAdminEmail;

	@Column(name="e_admin_first_name")
	private String eAdminFirstName;

	@Column(name="e_admin_last_name")
	private String eAdminLastName;

	@Column(name="e_admin_phone_no1")
	private String eAdminPhoneNo1;
	
	@Column(name="e_admin_phone_no2")
	private String eAdminPhoneNo2;

	@Column(name="e_admin_pin_code")
	private String eAdminPinCode;

	@Column(name="e_admin_state")
	private String eAdminState;

	//bi-directional many-to-one association to TEstateDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="estate_id")
	private TEstateDetail TEstateDetail;

	//bi-directional many-to-one association to TUsersLoginDetail
	@OneToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private TUsersLoginDetail TUsersLoginDetail1;

	//bi-directional many-to-one association to TUsersLoginDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="created_by")
	private TUsersLoginDetail TUsersLoginDetail2;

	//bi-directional many-to-one association to TEstateGateMan
	@OneToMany(mappedBy="TEstateAdmin")
	private List<TEstateGateMan> TEstateGateMans;

	//bi-directional many-to-one association to TPassDetail
	@OneToMany(mappedBy="TEstateAdmin")
	private List<TPassDetail> TPassDetails;

	//bi-directional many-to-one association to TEstateHost
	@OneToMany(mappedBy="TEstateAdmin")
	private List<TEstateHost> TEstateHosts;

	public TEstateAdmin() {
	}

	public long getEAdminId() {
		return this.eAdminId;
	}

	public void setEAdminId(long eAdminId) {
		this.eAdminId = eAdminId;
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

	

	public String geteAdminAddress1() {
		return eAdminAddress1;
	}

	public void seteAdminAddress1(String eAdminAddress1) {
		this.eAdminAddress1 = eAdminAddress1;
	}

	public String geteAdminAddress2() {
		return eAdminAddress2;
	}

	public void seteAdminAddress2(String eAdminAddress2) {
		this.eAdminAddress2 = eAdminAddress2;
	}

	public String getEAdminCity() {
		return this.eAdminCity;
	}

	public void setEAdminCity(String eAdminCity) {
		this.eAdminCity = eAdminCity;
	}

	public String getEAdminCountry() {
		return this.eAdminCountry;
	}

	public void setEAdminCountry(String eAdminCountry) {
		this.eAdminCountry = eAdminCountry;
	}

	public String getEAdminDistrict() {
		return this.eAdminDistrict;
	}

	public void setEAdminDistrict(String eAdminDistrict) {
		this.eAdminDistrict = eAdminDistrict;
	}

	public String getEAdminEmail() {
		return this.eAdminEmail;
	}

	public void setEAdminEmail(String eAdminEmail) {
		this.eAdminEmail = eAdminEmail;
	}

	public String getEAdminFirstName() {
		return this.eAdminFirstName;
	}

	public void setEAdminFirstName(String eAdminFirstName) {
		this.eAdminFirstName = eAdminFirstName;
	}

	public String getEAdminLastName() {
		return this.eAdminLastName;
	}

	public void setEAdminLastName(String eAdminLastName) {
		this.eAdminLastName = eAdminLastName;
	}

	public String geteAdminPhoneNo1() {
		return eAdminPhoneNo1;
	}

	public void seteAdminPhoneNo1(String eAdminPhoneNo1) {
		this.eAdminPhoneNo1 = eAdminPhoneNo1;
	}

	public String geteAdminPhoneNo2() {
		return eAdminPhoneNo2;
	}

	public void seteAdminPhoneNo2(String eAdminPhoneNo2) {
		this.eAdminPhoneNo2 = eAdminPhoneNo2;
	}

	public String getEAdminPinCode() {
		return this.eAdminPinCode;
	}

	public void setEAdminPinCode(String eAdminPinCode) {
		this.eAdminPinCode = eAdminPinCode;
	}

	public String getEAdminState() {
		return this.eAdminState;
	}

	public void setEAdminState(String eAdminState) {
		this.eAdminState = eAdminState;
	}

	public TEstateDetail getTEstateDetail() {
		return this.TEstateDetail;
	}

	public void setTEstateDetail(TEstateDetail TEstateDetail) {
		this.TEstateDetail = TEstateDetail;
	}

	public TUsersLoginDetail getTUsersLoginDetail1() {
		return this.TUsersLoginDetail1;
	}

	public void setTUsersLoginDetail1(TUsersLoginDetail TUsersLoginDetail1) {
		this.TUsersLoginDetail1 = TUsersLoginDetail1;
	}

	public TUsersLoginDetail getTUsersLoginDetail2() {
		return this.TUsersLoginDetail2;
	}

	public void setTUsersLoginDetail2(TUsersLoginDetail TUsersLoginDetail2) {
		this.TUsersLoginDetail2 = TUsersLoginDetail2;
	}

	public List<TEstateGateMan> getTEstateGateMans() {
		return this.TEstateGateMans;
	}

	public void setTEstateGateMans(List<TEstateGateMan> TEstateGateMans) {
		this.TEstateGateMans = TEstateGateMans;
	}

	
	public List<TPassDetail> getTPassDetails() {
		return this.TPassDetails;
	}

	public void setTPassDetails(List<TPassDetail> TPassDetails) {
		this.TPassDetails = TPassDetails;
	}

	

	public List<TEstateHost> getTEstateHosts() {
		return this.TEstateHosts;
	}

	public void setTEstateHosts(List<TEstateHost> TEstateHosts) {
		this.TEstateHosts = TEstateHosts;
	}

	
}