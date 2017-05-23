package com.shopping.global.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.constants.Constants;
import com.shopping.global.dto.SignUpDTO;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.services.SignUpServices;

@Component
public class SignUpBO {
	
	final static Logger logger = LoggerFactory.getLogger(SignUpBO.class);
	@Autowired
	private SignUpServices signUpServices;

	
	
	public ResponseDTO signUp(SignUpDTO signUpDTO) throws Exception{
		logger.debug("signUp :START");
		Boolean userCreatedFlag=null; 
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			userCreatedFlag=signUpServices.signUp(signUpDTO);
			if(userCreatedFlag){
				responseDTO.setStatus(Constants.SUCCESS);
			}
		}
		catch (Exception e) {
			throw e;
		}	
		logger.debug("signUp :END");
		return responseDTO;
	}
	

}
