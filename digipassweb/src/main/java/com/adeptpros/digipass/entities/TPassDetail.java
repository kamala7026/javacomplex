package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_pass_details database table.
 * 
 */
@Entity
@Table(name="t_pass_details")
@NamedQuery(name="TPassDetail.findAll", query="SELECT t FROM TPassDetail t")
public class TPassDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pass_id")
	private long passId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="visitor_address")
	private String visitorAddress;

	@Column(name="visitor_email_id")
	private String visitorEmailId;

	@Column(name="visitor_end_time")
	private Timestamp visitorEndTime;
	
	@Column(name="visitor_entry_time")
	private Timestamp visitorEntryTime;
	
	@Column(name="visitor_exist_time")
	private Timestamp visitorExistTime;
	

	@Column(name="visitor_equipment_details")
	private String visitorEquipmentDetails;

	@Column(name="visitor_first_name")
	private String visitorFirstName;

	@Column(name="visitor_instruction")
	private String visitorInstruction;

	@Column(name="visitor_last_name")
	private String visitorLastName;

	@Column(name="visitor_mob_no")
	private String visitorMobNo;

	@Column(name="visitor_pass_link")
	private String visitorPassLink;

	@Column(name="visitor_pass_status")
	private String visitorPassStatus;

	@Column(name="visitor_start_time")
	private Timestamp visitorStartTime;

	@Column(name="visitor_vechiles_details")
	private String visitorVechilesDetails;
	
	@Column(name="visitor_company_name")
	private String visitorCompanyName;
	
	@Column(name="visitor_vanue")
	private String visitorVanue;
	
	@Column(name="visitor_purpose")
	private String visitorPurpose;

	//bi-directional many-to-one association to TEstateAdmin
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="e_admin_id")
	private TEstateAdmin TEstateAdmin;

	//bi-directional many-to-one association to TEstateDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="estate_id")
	private TEstateDetail TEstateDetail;

	//bi-directional many-to-one association to TUsersLoginDetail
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="created_by")
	private TUsersLoginDetail TUsersLoginDetail;

	//bi-directional many-to-one association to TEstateHost
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="e_host_id")
	private TEstateHost TEstateHost;
	
	@Column(name="pass_approval_status")
	private int passApprovalStatus;
	
	

	

	public int getPassApprovalStatus() {
		return passApprovalStatus;
	}

	public void setPassApprovalStatus(int passApprovalStatus) {
		this.passApprovalStatus = passApprovalStatus;
	}

	public TPassDetail() {
	}

	public Timestamp getVisitorEntryTime() {
		return visitorEntryTime;
	}

	public void setVisitorEntryTime(Timestamp visitorEntryTime) {
		this.visitorEntryTime = visitorEntryTime;
	}

	public Timestamp getVisitorExistTime() {
		return visitorExistTime;
	}

	public void setVisitorExistTime(Timestamp visitorExistTime) {
		this.visitorExistTime = visitorExistTime;
	}

	public long getPassId() {
		return this.passId;
	}

	public void setPassId(long passId) {
		this.passId = passId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getVisitorAddress() {
		return this.visitorAddress;
	}

	public void setVisitorAddress(String visitorAddress) {
		this.visitorAddress = visitorAddress;
	}

	public String getVisitorEmailId() {
		return this.visitorEmailId;
	}

	public void setVisitorEmailId(String visitorEmailId) {
		this.visitorEmailId = visitorEmailId;
	}

	public Timestamp getVisitorEndTime() {
		return this.visitorEndTime;
	}

	public void setVisitorEndTime(Timestamp visitorEndTime) {
		this.visitorEndTime = visitorEndTime;
	}

	public String getVisitorEquipmentDetails() {
		return this.visitorEquipmentDetails;
	}

	public void setVisitorEquipmentDetails(String visitorEquipmentDetails) {
		this.visitorEquipmentDetails = visitorEquipmentDetails;
	}

	public String getVisitorFirstName() {
		return this.visitorFirstName;
	}

	public void setVisitorFirstName(String visitorFirstName) {
		this.visitorFirstName = visitorFirstName;
	}

	public String getVisitorInstruction() {
		return this.visitorInstruction;
	}

	public void setVisitorInstruction(String visitorInstruction) {
		this.visitorInstruction = visitorInstruction;
	}

	public String getVisitorLastName() {
		return this.visitorLastName;
	}

	public void setVisitorLastName(String visitorLastName) {
		this.visitorLastName = visitorLastName;
	}

	public String getVisitorMobNo() {
		return this.visitorMobNo;
	}

	public void setVisitorMobNo(String visitorMobNo) {
		this.visitorMobNo = visitorMobNo;
	}

	public String getVisitorPassLink() {
		return this.visitorPassLink;
	}

	public void setVisitorPassLink(String visitorPassLink) {
		this.visitorPassLink = visitorPassLink;
	}

	public String getVisitorPassStatus() {
		return this.visitorPassStatus;
	}

	public void setVisitorPassStatus(String visitorPassStatus) {
		this.visitorPassStatus = visitorPassStatus;
	}

	public Timestamp getVisitorStartTime() {
		return this.visitorStartTime;
	}

	public void setVisitorStartTime(Timestamp visitorStartTime) {
		this.visitorStartTime = visitorStartTime;
	}

	public String getVisitorVechilesDetails() {
		return this.visitorVechilesDetails;
	}

	public void setVisitorVechilesDetails(String visitorVechilesDetails) {
		this.visitorVechilesDetails = visitorVechilesDetails;
	}

	public TEstateAdmin getTEstateAdmin() {
		return this.TEstateAdmin;
	}

	public void setTEstateAdmin(TEstateAdmin TEstateAdmin) {
		this.TEstateAdmin = TEstateAdmin;
	}

	public TEstateDetail getTEstateDetail() {
		return this.TEstateDetail;
	}

	public void setTEstateDetail(TEstateDetail TEstateDetail) {
		this.TEstateDetail = TEstateDetail;
	}

	public TUsersLoginDetail getTUsersLoginDetail() {
		return this.TUsersLoginDetail;
	}

	public void setTUsersLoginDetail(TUsersLoginDetail TUsersLoginDetail) {
		this.TUsersLoginDetail = TUsersLoginDetail;
	}

	public TEstateHost getTEstateHost() {
		return this.TEstateHost;
	}

	public void setTEstateHost(TEstateHost TEstateHost) {
		this.TEstateHost = TEstateHost;
	}

	public String getVisitorCompanyName() {
		return visitorCompanyName;
	}

	public void setVisitorCompanyName(String visitorCompanyName) {
		this.visitorCompanyName = visitorCompanyName;
	}

	public String getVisitorVanue() {
		return visitorVanue;
	}

	public void setVisitorVanue(String visitorVanue) {
		this.visitorVanue = visitorVanue;
	}

	public String getVisitorPurpose() {
		return visitorPurpose;
	}

	public void setVisitorPurpose(String visitorPurpose) {
		this.visitorPurpose = visitorPurpose;
	}

	
	

}