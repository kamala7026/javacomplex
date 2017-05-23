package com.shopping.global.bean;

import java.io.Serializable;

public class WildCardSearchBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8399133822363461350L;
	
	private String searchString;
	
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	@Override
	public String toString() {
		return "CustomerSearchDetailsBean [searchString=" + searchString + "]";
	}
	
	


	
}
