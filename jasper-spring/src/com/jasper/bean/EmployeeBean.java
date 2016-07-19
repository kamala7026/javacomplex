package com.jasper.bean;

import java.util.Date;
import java.util.List;

public class EmployeeBean{
	private int empNo;
	private Date birthDate;
	private String firstName;
	private String gender;
	private Date hireDate;
	private String lastName;
	private String department;
	private List<SalaryBean> salaryList;
	
	public EmployeeBean() {
	}

	

	public List<SalaryBean> getSalaryList() {
		return salaryList;
	}



	public void setSalaryList(List<SalaryBean> salaryList) {
		this.salaryList = salaryList;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}