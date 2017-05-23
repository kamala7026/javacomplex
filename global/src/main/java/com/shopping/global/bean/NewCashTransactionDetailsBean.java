package com.shopping.global.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.shopping.global.dto.CustomerSearchDTO;

public class NewCashTransactionDetailsBean  implements Serializable{

		private static final long serialVersionUID = -2370662036105652029L;

	    private List<CustomerSearchDTO> listofCustomers;
	    
	    private String customerDetails;
	    
	    private String customerId;

		private String godownNo;

		private String name;
	    
		private BigInteger cashtransactionId;
		
		private double amount;
		
		private String typeOfTransact;
		
		private Date paidDate;

		
		public String getCustomerDetails() {
			return customerDetails;
		}

		public void setCustomerDetails(String customerDetails) {
			this.customerDetails = customerDetails;
		}
		
		public List<CustomerSearchDTO> getListofCustomers() {
			return listofCustomers;
		}

		public void setListofCustomers(List<CustomerSearchDTO> listofCustomers) {
			this.listofCustomers = listofCustomers;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getGodownNo() {
			return godownNo;
		}

		public void setGodownNo(String godownNo) {
			this.godownNo = godownNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public BigInteger getCashtransactionId() {
			return cashtransactionId;
		}

		public void setCashtransactionId(BigInteger cashtransactionId) {
			this.cashtransactionId = cashtransactionId;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getTypeOfTransact() {
			return typeOfTransact;
		}

		public void setTypeOfTransact(String typeOfTransact) {
			this.typeOfTransact = typeOfTransact;
		}

		public Date getPaidDate() {
			return paidDate;
		}

		public void setPaidDate(Date paidDate) {
			this.paidDate = paidDate;
		}

		@Override
		public String toString() {
			return "NewCashTransactionDetailsBean [listofCustomers=" + listofCustomers + ", customerDetails="
					+ customerDetails + ", customerId=" + customerId + ", godownNo=" + godownNo + ", name=" + name
					+ ", cashtransactionId=" + cashtransactionId + ", amount=" + amount + ", typeOfTransact="
					+ typeOfTransact + ", paidDate=" + paidDate + "]";
		}
}
