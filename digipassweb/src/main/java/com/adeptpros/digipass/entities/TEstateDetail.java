package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_estate_details database table.
 * 
 */
@Entity
@Table(name="t_estate_details")
@NamedQuery(name="TEstateDetail.findAll", query="SELECT t FROM TEstateDetail t")
public class TEstateDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="estate_id")
	private long estateId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="estate_address1")
	private String estateAddress1;

	@Column(name="estate_address2")
	private String estateAddress2;
	
	@Column(name="estate_city")
	private String estateCity;

	@Column(name="estate_country")
	private String estateCountry;

	@Column(name="estate_district")
	private String estateDistrict;

	@Column(name="estate_entry_points")
	private int estateEntryPoints;

	@Column(name="estate_exist_points")
	private int estateExistPoints;

	@Column(name="estate_name")
	private String estateName;

	@Column(name="estate_organisation")
	private String estateOrganisation;

	@Column(name="estate_pin_code")
	private String estatePinCode;

	@Column(name="estate_state")
	private String estateState;

	@Column(name="estate_title")
	private String estateTitle;

	@Column(name="estate_type")
	private String estateType;
	
	@Column(name="estate_mobile_no")
	private String estateMobileNo;
	
	@Column(name="estate_email")
	private String estateEmail;
	

	//bi-directional many-to-one association to TEstateAdmin
	@OneToMany(mappedBy="TEstateDetail")
	private List<TEstateAdmin> TEstateAdmins;

	//bi-directional many-to-one association to TUsersLoginDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="created_by")
	private TUsersLoginDetail TUsersLoginDetail;

	//bi-directional many-to-one association to TEstateGateMan
	@OneToMany(mappedBy="TEstateDetail")
	private List<TEstateGateMan> TEstateGateMans;

	//bi-directional many-to-one association to TPassDetail
	@OneToMany(mappedBy="TEstateDetail")
	private List<TPassDetail> TPassDetails;

	//bi-directional many-to-one association to TEstateHost
	@OneToMany(mappedBy="TEstateDetail")
	private List<TEstateHost> TEstateHosts;

	public TEstateDetail() {
	}

	public long getEstateId() {
		return this.estateId;
	}

	public void setEstateId(long estateId) {
		this.estateId = estateId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	

	public String getEstateAddress1() {
		return estateAddress1;
	}

	public void setEstateAddress1(String estateAddress1) {
		this.estateAddress1 = estateAddress1;
	}

	public String getEstateAddress2() {
		return estateAddress2;
	}

	public void setEstateAddress2(String estateAddress2) {
		this.estateAddress2 = estateAddress2;
	}

	public String getEstateCity() {
		return this.estateCity;
	}

	public void setEstateCity(String estateCity) {
		this.estateCity = estateCity;
	}

	public String getEstateCountry() {
		return this.estateCountry;
	}

	public void setEstateCountry(String estateCountry) {
		this.estateCountry = estateCountry;
	}

	public String getEstateDistrict() {
		return this.estateDistrict;
	}

	public void setEstateDistrict(String estateDistrict) {
		this.estateDistrict = estateDistrict;
	}

	public int getEstateEntryPoints() {
		return this.estateEntryPoints;
	}

	public void setEstateEntryPoints(int estateEntryPoints) {
		this.estateEntryPoints = estateEntryPoints;
	}

	public int getEstateExistPoints() {
		return this.estateExistPoints;
	}

	public void setEstateExistPoints(int estateExistPoints) {
		this.estateExistPoints = estateExistPoints;
	}

	public String getEstateName() {
		return this.estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public String getEstateOrganisation() {
		return this.estateOrganisation;
	}

	public void setEstateOrganisation(String estateOrganisation) {
		this.estateOrganisation = estateOrganisation;
	}

	public String getEstatePinCode() {
		return this.estatePinCode;
	}

	public void setEstatePinCode(String estatePinCode) {
		this.estatePinCode = estatePinCode;
	}

	public String getEstateState() {
		return this.estateState;
	}

	public void setEstateState(String estateState) {
		this.estateState = estateState;
	}

	public String getEstateTitle() {
		return this.estateTitle;
	}

	public void setEstateTitle(String estateTitle) {
		this.estateTitle = estateTitle;
	}

	public String getEstateType() {
		return this.estateType;
	}

	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	public List<TEstateAdmin> getTEstateAdmins() {
		return this.TEstateAdmins;
	}

	public void setTEstateAdmins(List<TEstateAdmin> TEstateAdmins) {
		this.TEstateAdmins = TEstateAdmins;
	}

	

	public TUsersLoginDetail getTUsersLoginDetail() {
		return this.TUsersLoginDetail;
	}

	public void setTUsersLoginDetail(TUsersLoginDetail TUsersLoginDetail) {
		this.TUsersLoginDetail = TUsersLoginDetail;
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

	public String getEstateMobileNo() {
		return estateMobileNo;
	}

	public void setEstateMobileNo(String estateMobileNo) {
		this.estateMobileNo = estateMobileNo;
	}

	public String getEstateEmail() {
		return estateEmail;
	}

	public void setEstateEmail(String estateEmail) {
		this.estateEmail = estateEmail;
	}

	

}