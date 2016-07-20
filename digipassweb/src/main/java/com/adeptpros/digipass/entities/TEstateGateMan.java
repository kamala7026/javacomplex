package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_estate_gate_man database table.
 * 
 */
@Entity
@Table(name="t_estate_gate_man")
@NamedQuery(name="TEstateGateMan.findAll", query="SELECT t FROM TEstateGateMan t")
public class TEstateGateMan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="e_gate_man_id")
	private long eGateManId;

	@Column(name="active_status")
	private int activeStatus;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="e_gate_man_address1")
	private String eGateManAddress1;
	
	@Column(name="e_gate_man_address2")
	private String eGateManAddress2;

	@Column(name="e_gate_man_email_id")
	private String eGateManEmailId;

	@Column(name="e_gate_man_first_name")
	private String eGateManFirstName;
	
	@Column(name="e_gate_man_last_name")
	private String eGateManLastName;

	@Column(name="e_gate_man_phone_no1")
	private String eGateManPhoneNo1;
	
	@Column(name="e_gate_man_phone_no2")
	private String eGateManPhoneNo2;

	//bi-directional many-to-one association to TEstateAdmin
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="e_admin_id")
	private TEstateAdmin TEstateAdmin;

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

	

	public TEstateGateMan() {
	}

	public long getEGateManId() {
		return this.eGateManId;
	}

	public void setEGateManId(long eGateManId) {
		this.eGateManId = eGateManId;
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
	
	public String geteGateManAddress1() {
		return eGateManAddress1;
	}

	public void seteGateManAddress1(String eGateManAddress1) {
		this.eGateManAddress1 = eGateManAddress1;
	}

	public String geteGateManAddress2() {
		return eGateManAddress2;
	}

	public void seteGateManAddress2(String eGateManAddress2) {
		this.eGateManAddress2 = eGateManAddress2;
	}

	public String getEGateManEmailId() {
		return this.eGateManEmailId;
	}

	public void setEGateManEmailId(String eGateManEmailId) {
		this.eGateManEmailId = eGateManEmailId;
	}

	
	public String geteGateManFirstName() {
		return eGateManFirstName;
	}

	public void seteGateManFirstName(String eGateManFirstName) {
		this.eGateManFirstName = eGateManFirstName;
	}

	public String geteGateManLastName() {
		return eGateManLastName;
	}

	public void seteGateManLastName(String eGateManLastName) {
		this.eGateManLastName = eGateManLastName;
	}

	public String geteGateManPhoneNo1() {
		return eGateManPhoneNo1;
	}

	public void seteGateManPhoneNo1(String eGateManPhoneNo1) {
		this.eGateManPhoneNo1 = eGateManPhoneNo1;
	}

	public String geteGateManPhoneNo2() {
		return eGateManPhoneNo2;
	}

	public void seteGateManPhoneNo2(String eGateManPhoneNo2) {
		this.eGateManPhoneNo2 = eGateManPhoneNo2;
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

	

}