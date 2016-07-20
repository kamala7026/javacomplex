package com.adeptpros.digipass.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.PassBean;
import com.adeptpros.digipass.dao.PassCreateDAO;

@Component
public class PassCreateBo {

	@Autowired
	private PassCreateDAO createPassDAO;
	
	public PassCreateDAO getCreatePassDAO() {
		return createPassDAO;
	}

	public void setCreatePassDAO(PassCreateDAO createPassDAO) {
		this.createPassDAO = createPassDAO;
	}

	public String createPass(PassBean pass)throws Exception {
		String status=null;
		try {
			status=this.getCreatePassDAO().createPass(pass);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

}
