package com.shopping.global.bean;

import java.io.Serializable;
import java.util.List;

import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;

public class NewBillDetailsBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8399133822363461350L;
	
    private List<CustomerSearchDTO> listofCustomers;
    private List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList;
    
	public List<CustomerSearchDTO> getListofCustomers() {
		return listofCustomers;
	}
	public void setListofCustomers(List<CustomerSearchDTO> listofCustomers) {
		this.listofCustomers = listofCustomers;
	}
	public List<ProductQuanityDetailsDTO> getProductQuanityDetailsDTOList() {
		return ProductQuanityDetailsDTOList;
	}
	public void setProductQuanityDetailsDTOList(List<ProductQuanityDetailsDTO> productQuanityDetailsDTOList) {
		ProductQuanityDetailsDTOList = productQuanityDetailsDTOList;
	}
	@Override
	public String toString() {
		return "NewBillDetailsBean [listofCustomers=" + listofCustomers + ", ProductQuanityDetailsDTOList="
				+ ProductQuanityDetailsDTOList + "]";
	}
    
    

	
}
