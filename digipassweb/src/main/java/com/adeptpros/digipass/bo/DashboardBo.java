package com.adeptpros.digipass.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.Dashboard;
import com.adeptpros.digipass.beans.HostUsers;
import com.adeptpros.digipass.dao.DashboardDao;
import com.adeptpros.digipass.dao.HostUsersDao;

@Component
public class DashboardBo {
	@Autowired
	private HostUsersDao hostUsersDao;
	
	
	public HostUsersDao getHostUsersDao() {
		return hostUsersDao;
	}

	public void setHostUsersDao(HostUsersDao hostUsersDao) {
		this.hostUsersDao = hostUsersDao;
	}
	@Autowired
	private DashboardDao dashboardDao;

	public DashboardDao getDashboardDao() {
		return dashboardDao;
	}

	public void setDashboardDao(DashboardDao dashboardDao) {
		this.dashboardDao = dashboardDao;
	}

	public Dashboard getDashboardInfo(String userName) {
		Dashboard dashboard=null;
		try {
			dashboard=this.getDashboardDao().getDashboardInfo(userName);
			
		} catch (Exception e) {
			throw e;
		}
		return dashboard;
	}
	public List<HostUsers> getAllUsersByAdminId(String userName) throws Exception {
		List<HostUsers> estateUsersList=new ArrayList<HostUsers>();
		try {
			estateUsersList=this.getHostUsersDao().getAllUsersByAdminId(userName);
		} catch (Exception e) {
			throw e;
		}		
		return estateUsersList;
	}
	
}
