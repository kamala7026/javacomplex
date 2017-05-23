package com.shopping.global.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListOfProductQuanityDetailsDTO implements Serializable {

	public ListOfProductQuanityDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -75532315075046164L;

	private String customerId;
	private List<NewBillProductDTO> billItems=new ArrayList<NewBillProductDTO>();

	private double basicAmount;

	private double billAmount;

	private Date billDate;
	
	private double dueAmount;

	private String godownNo;

	private double paidAmount;

	private String paymentType;

	private String customerName;
	
	private double vatAmount;
	
	private String customerDetails;
	
	private String billNumber;
	
	

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<NewBillProductDTO> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<NewBillProductDTO> billItem) {
		this.billItems = billItem;
	}

	@Override
	public String toString() {
		return "ListOfProductQuanityDetailsDTO [customerId=" + customerId + ", billItems=" + billItems
				+ ", basicAmount=" + basicAmount + ", billAmount=" + billAmount + ", billDate=" + billDate
				+ ", dueAmount=" + dueAmount + ", godownNo=" + godownNo + ", paidAmount=" + paidAmount
				+ ", paymentType=" + paymentType + ", customerName=" + customerName + ", vatAmount=" + vatAmount
				+ ", customerDetails=" + customerDetails + ", billNumber=" + billNumber + "]";
	}

	public double getBasicAmount() {
		return basicAmount;
	}

	public void setBasicAmount(double basicAmount) {
		this.basicAmount = basicAmount;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getGodownNo() {
		return godownNo;
	}

	public void setGodownNo(String godownNo) {
		this.godownNo = godownNo;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public ListOfProductQuanityDetailsDTO(String customerId, List<NewBillProductDTO> billItems, double basicAmount,
			double billAmount, Date billDate, double dueAmount, String godownNo, double paidAmount, String paymentType,
			String customerName, double vatAmount, String customerDetails) {
		super();
		this.customerId = customerId;
		this.billItems = billItems;
		this.basicAmount = basicAmount;
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.dueAmount = dueAmount;
		this.godownNo = godownNo;
		this.paidAmount = paidAmount;
		this.paymentType = paymentType;
		this.customerName = customerName;
		this.vatAmount = vatAmount;
		this.customerDetails = customerDetails;
	}
	
	
}