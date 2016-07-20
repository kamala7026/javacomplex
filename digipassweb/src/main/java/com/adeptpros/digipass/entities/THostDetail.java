package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.math.BigInteger;


/**
 * The persistent class for the t_host_details database table.
 * 
 */
@Entity
@Table(name="t_host_details")
@NamedQuery(name="THostDetail.findAll", query="SELECT t FROM THostDetail t")
public class THostDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="email_id")
	private String emailId;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="first_name")
	private String firstName;

	@Column(name="host_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger hostId;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone_no")
	private String phoneNo;

	//bi-directional one-to-one association to TUserLogin
	@OneToOne(mappedBy="THostDetail")
	private TUserLogin TUserLogin;
	
	@OneToMany(mappedBy="THostDetail", fetch=FetchType.EAGER)
	private List<TPassDetail> TPassDetails;

	public THostDetail() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public BigInteger getHostId() {
		return this.hostId;
	}

	public void setHostId(BigInteger hostId) {
		this.hostId = hostId;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public TUserLogin getTUserLogin() {
		return this.TUserLogin;
	}

	public void setTUserLogin(TUserLogin TUserLogin) {
		this.TUserLogin = TUserLogin;
	}

	public List<TPassDetail> getTPassDetails() {
		return TPassDetails;
	}

	public void setTPassDetails(List<TPassDetail> tPassDetails) {
		TPassDetails = tPassDetails;
	}

}