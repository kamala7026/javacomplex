package com.shopping.global.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.global.dao.LoginDAO;
import com.shopping.global.dto.SignUpDTO;
@Service
public class SignUpServices {
	
	final static Logger logger = LoggerFactory.getLogger(SignUpServices.class);
	
	@Autowired
	private LoginDAO loginDAO;

	public Boolean signUp(SignUpDTO signUpData) throws Exception{
		logger.debug("signUp :START");
		Boolean userCreatedFlag=false;
		try {
			signUpData.setShopId("1");
			signUpData.setStatus("R");;
			userCreatedFlag=loginDAO.signUp(signUpData);
		}
		catch (Exception e) {
			throw e;
		}		
		logger.debug("signUp :END");
		return userCreatedFlag;
	}

}
