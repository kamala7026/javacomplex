package com.adeptpros.digipass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_role_details database table.
 * 
 */
@Entity
@Table(name="t_role_details")
@NamedQuery(name="TRoleDetail.findAll", query="SELECT t FROM TRoleDetail t")
public class TRoleDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private long roleId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to TUsersLoginDetail
	@OneToMany(mappedBy="TRoleDetail")
	private List<TUsersLoginDetail> TUsersLoginDetails;

	public TRoleDetail() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<TUsersLoginDetail> getTUsersLoginDetails() {
		return this.TUsersLoginDetails;
	}

	public void setTUsersLoginDetails(List<TUsersLoginDetail> TUsersLoginDetails) {
		this.TUsersLoginDetails = TUsersLoginDetails;
	}

	

}