package com.adeptpros.digipass.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.EstateDetails;
import com.adeptpros.digipass.dao.EstateDao;

@Component
public class EstateBo {
	@Autowired
	private EstateDao estateDao;

	public EstateDao getEstateDao() {
		return estateDao;
	}

	public void setEstateDao(EstateDao estateDao) {
		this.estateDao = estateDao;
	}

	

	public EstateDetails getEstateDetails(String userName) throws Exception {
		EstateDetails estateDetails=null;
		try {
			estateDetails=this.estateDao.getEstateDetails(userName);
		} catch (Exception e) {
			throw e;
		}
		return estateDetails;
	}
	
}
