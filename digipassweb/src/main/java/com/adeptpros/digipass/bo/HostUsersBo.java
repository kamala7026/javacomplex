package com.adeptpros.digipass.bo;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.adeptpros.digipass.beans.HostUsers;
import com.adeptpros.digipass.dao.HostUsersDao;

import au.com.bytecode.opencsv.CSVReader;

@Component
public class HostUsersBo {
	@Autowired
	private HostUsersDao hostUsersDao;
	
	
	public HostUsersDao getHostUsersDao() {
		return hostUsersDao;
	}

	public void setHostUsersDao(HostUsersDao hostUsersDao) {
		this.hostUsersDao = hostUsersDao;
	}

	public List<HostUsers> getAllUsersByAdminId(String userName) throws Exception {
		List<HostUsers> estateUsersList=new ArrayList<HostUsers>();
		try {
			estateUsersList=this.hostUsersDao.getAllUsersByAdminId(userName);
		} catch (Exception e) {
			throw e;
		}		
		return estateUsersList;
	}

	public HostUsers addHostUser(String userName, HostUsers estateUser) throws Exception {
		HostUsers hostUser=null;
		try {
			hostUser=this.hostUsersDao.addHostUser(userName,estateUser);
			
		} catch (Exception e) {
			throw e;
		}
		return hostUser;
	}

	public String setAccess(HostUsers hostUser) throws Exception {
		String status="";
		try {
			status=this.hostUsersDao.setAccess(hostUser);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public String checkDuplicate(Model model,File newFile, MultipartHttpServletRequest request, String userName) throws Exception {
		String status="";
		try {
			status=this.getHostUsersDao().checkDuplicate(model,newFile, request, userName);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
	
	public String uploadHostUsers(File file,HttpServletRequest request,String userName,Model model) throws Exception{
		String status="";
		
		try{
			status=this.getHostUsersDao().uploadHostUser(file, request, userName, model);
		}catch (Exception e) {
			throw e;
		}
		return status;
		
	}

	public HostUsers getHostDetailsBthostId(Long hostId) {
		HostUsers hostUsers=new HostUsers();
		hostUsers=this.getHostUsersDao().getHostDetailsBthostId(hostId);
		return hostUsers;
	}

	public HostUsers updateHost(String userName, HostUsers hostUser) throws Exception {
		HostUsers hostUser1=null;
		try {
			hostUser1=this.hostUsersDao.updateHost(userName,hostUser);
			
		} catch (Exception e) {
			throw e;
		}
		return hostUser1;
	}

	public String duplicateMobileCheck(String value) {
		String status=null;
		try {
			status=this.hostUsersDao.duplicateMobileCheck(value);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public String duplicateEmailCheck(String value) {
		String status=null;
		try {
			status=this.hostUsersDao.duplicateEmailCheck(value);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

}
