package com.adeptpros.digipass.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.AdminUser;
import com.adeptpros.digipass.dao.AdminUsersDao;

@Component
public class AdminUsersBo {

	@Autowired
	private AdminUsersDao adminUsersDao;

	public AdminUsersDao getAdminUsersDao() {
		return adminUsersDao;
	}

	public void setAdminUsersDao(AdminUsersDao adminUsersDao) {
		this.adminUsersDao = adminUsersDao;
	}

	public String registerAdminUser(AdminUser adminUser) {
		String status=null;
		try {
			status=this.getAdminUsersDao().registerAdminUser(adminUser);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
	
	public String duplicateEmailCheck(String value) {
		String status=null;
		try {
			status=this.getAdminUsersDao().duplicateEmailCheck(value);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public List<AdminUser> getAllAdminUserBySuperAdminUser(String userName) {
		List<AdminUser> adminUsersList=null;
		try {
			adminUsersList=this.getAdminUsersDao().getAllAdminUserBySuperAdminUser(userName);
		} catch (Exception e) {
			throw e;
		}
		return adminUsersList;
	}

	public String setAccess(AdminUser adminUser) throws Exception {
		String status=null;
		try {
			status=this.getAdminUsersDao().setAccess(adminUser);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	public AdminUser getAdminUser(String userName) {
		AdminUser adminUser=null;
		try {
			adminUser=this.getAdminUsersDao().getAdminUser(userName);
		} catch (Exception e) {
			throw e;
		}
		return adminUser;
	}

	public String updateAdminUser(AdminUser adminUser) {
		String status="";
		try {
			status=this.getAdminUsersDao().updateAdminUser(adminUser);
		} catch (Exception e) {
			throw e;
		}
		return status;
	}
}
