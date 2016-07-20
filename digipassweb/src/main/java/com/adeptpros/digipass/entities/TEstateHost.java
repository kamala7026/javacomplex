package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_estate_host database table.
 * 
 */
@Entity
@Table(name="t_estate_host")
@NamedQuery(name="TEstateHost.findAll", query="SELECT t FROM TEstateHost t")
public class TEstateHost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="e_host_id")
	private long eHostId;

	@Column(name="active_status")
	private int activeStatus;

	@Column(name="building_no")
	private String buildingNo;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="e_host_address1")
	private String eHostAddress1;

	@Column(name="e_host_address2")
	private String eHostAddress2;
	
	@Column(name="e_host_city")
	private String eHostCity;

	@Column(name="e_host_country")
	private String eHostCountry;

	@Column(name="e_host_district")
	private String eHostDistrict;

	@Temporal(TemporalType.DATE)
	@Column(name="e_host_dob")
	private Date eHostDob;

	@Column(name="e_host_email1")
	private String eHostEmail1;
	
	@Column(name="e_host_email2")
	private String eHostEmail2;

	@Column(name="e_host_first_name")
	private String eHostFirstName;

	@Column(name="e_host_last_name")
	private String eHostLastName;

	@Column(name="e_host_phone_no1")
	private String eHostPhoneNo1;
	
	@Column(name="e_host_phone_no2")
	private String eHostPhoneNo2;

	@Column(name="e_host_pin_code")
	private String eHostPinCode;

	@Column(name="e_host_state")
	private String eHostState;
	
	@Column(name="e_host_type")
	private String eHostType;
	
	@Column(name="e_host_department")
	private String eHostDepartment;
	

	@Column(name="user_status")
	private int userStatus;
	
	@Column(name="grant_access")
	private int grantAccess;

	@Column(name="expired_date")
	private Timestamp expiredDate;
	
	@Column(name="valid_from")
	private Timestamp validFrom;

	

	//bi-directional many-to-one association to TEstateDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="estate_id")
	private TEstateDetail TEstateDetail;

	//bi-directional many-to-one association to TEstateAdmin
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="e_admin_id")
	private TEstateAdmin TEstateAdmin;

	//bi-directional many-to-one association to TUsersLoginDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private TUsersLoginDetail TUsersLoginDetail1;

	//bi-directional many-to-one association to TUsersLoginDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="created_by")
	private TUsersLoginDetail TUsersLoginDetail2;

	//bi-directional many-to-one association to TPassDetail
	@OneToMany(mappedBy="TEstateHost")
	private List<TPassDetail> TPassDetails;

	public TEstateHost() {
	}

	
	public String geteHostDepartment() {
		return eHostDepartment;
	}


	public void seteHostDepartment(String eHostDepartment) {
		this.eHostDepartment = eHostDepartment;
	}


	public long getEHostId() {
		return this.eHostId;
	}

	public void setEHostId(long eHostId) {
		this.eHostId = eHostId;
	}

	public int getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	

	public String geteHostAddress1() {
		return eHostAddress1;
	}

	public void seteHostAddress1(String eHostAddress1) {
		this.eHostAddress1 = eHostAddress1;
	}

	public String geteHostAddress2() {
		return eHostAddress2;
	}

	public void seteHostAddress2(String eHostAddress2) {
		this.eHostAddress2 = eHostAddress2;
	}

	public String getEHostCity() {
		return this.eHostCity;
	}

	public void setEHostCity(String eHostCity) {
		this.eHostCity = eHostCity;
	}

	public String getEHostCountry() {
		return this.eHostCountry;
	}

	public void setEHostCountry(String eHostCountry) {
		this.eHostCountry = eHostCountry;
	}

	public String getEHostDistrict() {
		return this.eHostDistrict;
	}

	public void setEHostDistrict(String eHostDistrict) {
		this.eHostDistrict = eHostDistrict;
	}

	public Date getEHostDob() {
		return this.eHostDob;
	}

	public void setEHostDob(Date eHostDob) {
		this.eHostDob = eHostDob;
	}

	
	public String geteHostEmail1() {
		return eHostEmail1;
	}

	public void seteHostEmail1(String eHostEmail1) {
		this.eHostEmail1 = eHostEmail1;
	}

	public String geteHostEmail2() {
		return eHostEmail2;
	}

	public void seteHostEmail2(String eHostEmail2) {
		this.eHostEmail2 = eHostEmail2;
	}

	public String getEHostFirstName() {
		return this.eHostFirstName;
	}

	public void setEHostFirstName(String eHostFirstName) {
		this.eHostFirstName = eHostFirstName;
	}

	public String getEHostLastName() {
		return this.eHostLastName;
	}

	public void setEHostLastName(String eHostLastName) {
		this.eHostLastName = eHostLastName;
	}

	public String geteHostPhoneNo1() {
		return eHostPhoneNo1;
	}

	public void seteHostPhoneNo1(String eHostPhoneNo1) {
		this.eHostPhoneNo1 = eHostPhoneNo1;
	}

	public String geteHostPhoneNo2() {
		return eHostPhoneNo2;
	}

	public void seteHostPhoneNo2(String eHostPhoneNo2) {
		this.eHostPhoneNo2 = eHostPhoneNo2;
	}

	public String getEHostPinCode() {
		return this.eHostPinCode;
	}

	public void setEHostPinCode(String eHostPinCode) {
		this.eHostPinCode = eHostPinCode;
	}

	public String getEHostState() {
		return this.eHostState;
	}

	public void setEHostState(String eHostState) {
		this.eHostState = eHostState;
	}

	public int getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	

	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public TEstateDetail getTEstateDetail() {
		return this.TEstateDetail;
	}

	public void setTEstateDetail(TEstateDetail TEstateDetail) {
		this.TEstateDetail = TEstateDetail;
	}

	public TEstateAdmin getTEstateAdmin() {
		return this.TEstateAdmin;
	}

	public void setTEstateAdmin(TEstateAdmin TEstateAdmin) {
		this.TEstateAdmin = TEstateAdmin;
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

	public List<TPassDetail> getTPassDetails() {
		return this.TPassDetails;
	}

	public void setTPassDetails(List<TPassDetail> TPassDetails) {
		this.TPassDetails = TPassDetails;
	}
	

	public int getGrantAccess() {
		return grantAccess;
	}

	public void setGrantAccess(int grantAccess) {
		this.grantAccess = grantAccess;
	}

	public Timestamp getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	public String geteHostType() {
		return eHostType;
	}

	public void seteHostType(String eHostType) {
		this.eHostType = eHostType;
	}
	

}