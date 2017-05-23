package com.shopping.global.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.global.constants.Constants;
import com.shopping.global.dao.LoginDAO;
import com.shopping.global.dto.LoginDTO;
import com.shopping.global.exception.PasswordIncorrectException;
import com.shopping.global.exception.UserNotApprovedExeception;
@Service
public class LoginServices {
	
	final static Logger logger = LoggerFactory.getLogger(LoginServices.class);
	
	@Autowired
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public LoginDTO userAuth(LoginDTO loginDTO) throws Exception{
		logger.debug("userAuth :START");
		LoginDTO loginDTO2=null;
		try {
			loginDTO2=this.getLoginDAO().userAuth(loginDTO);
			if(null != loginDTO2){
				if(! loginDTO2.getStatus().equalsIgnoreCase(Constants.APPROVE_STATUS)){
					throw new UserNotApprovedExeception();
				}
			}
		}catch (PasswordIncorrectException e) {
			throw e;
		}
		catch (UserNotApprovedExeception e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}		
		logger.debug("userAuth :END");
		return loginDTO2;
	}

}
