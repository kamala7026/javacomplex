package com.adeptpros.digipass.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.ChangePassword;
import com.adeptpros.digipass.beans.UserLogin;
import com.adeptpros.digipass.dao.UserLoginDao;

@Component
public class UserLoginBo {
	
	@Autowired
	private UserLoginDao userLoginDao;

	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}

	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}
	
	public UserLogin userLogin(UserLogin userLogin) throws Exception{
		UserLogin userLogin2=new UserLogin();
		try {
			userLogin2=this.userLoginDao.userLogin(userLogin);			
		} catch (Exception e) {
			throw e;
		}
		return userLogin2;
	}

	public String changePassword(ChangePassword changePassword) throws Exception {
		String status="";
		try {
			status=this.getUserLoginDao().changePassword(changePassword);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public String forgetPassword(UserLogin userLogin) throws Exception {
		String status="";
		try {
			status=this.getUserLoginDao().forgetPassword(userLogin);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
	
}
