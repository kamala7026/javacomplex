package com.shopping.global.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.constants.Constants;
import com.shopping.global.dto.LoginDTO;
import com.shopping.global.exception.PasswordIncorrectException;
import com.shopping.global.exception.UserNotApprovedExeception;
import com.shopping.global.services.LoginServices;
import com.shopping.global.services.ResponseDTO;

@Component
public class LoginBO {
	
	final static Logger logger = LoggerFactory.getLogger(LoginBO.class);
	@Autowired
	private LoginServices loginServices;

	public LoginServices getLoginServices() {
		return loginServices;
	}

	public void setLoginServices(LoginServices loginServices) {
		this.loginServices = loginServices;
	}
	
	public ResponseDTO userAuth(LoginDTO loginDTO) throws Exception{
		logger.debug("userAuth :START");
		LoginDTO loginDTO2=null; 
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			loginDTO2=this.getLoginServices().userAuth(loginDTO);
			if(null !=loginDTO2){
				responseDTO.setResponseObject(loginDTO2);
				responseDTO.setStatus(Constants.SUCCESS);
			}
		} catch (PasswordIncorrectException e) {
			throw e;
		}
		catch (UserNotApprovedExeception e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}	
		logger.debug("userAuth :END");
		return responseDTO;
	}
	

}
