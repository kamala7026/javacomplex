package com.shopping.global.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;

public class BillReportFactory {

	public static Collection<ListOfProductQuanityDetailsDTO> listOfProductQuanityDetailsDTO(){
		List<ListOfProductQuanityDetailsDTO> listOfProductQuanityDetailsDTO=new ArrayList<>();
		ListOfProductQuanityDetailsDTO detailsDTO=new ListOfProductQuanityDetailsDTO();
		listOfProductQuanityDetailsDTO.add(detailsDTO);
		return listOfProductQuanityDetailsDTO;	
	}
}
