package com.adeptpros.digipass.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.PassHistory;
import com.adeptpros.digipass.dao.PassHistoryDao;
@Component
public class PassHistoryBo {
	@Autowired
	private PassHistoryDao passHistoryDao;
	

	public PassHistoryDao getPassHistoryDao() {
		return passHistoryDao;
	}


	public void setPassHistoryDao(PassHistoryDao passHistoryDao) {
		this.passHistoryDao = passHistoryDao;
	}


	public List<PassHistory> getPassHistory(String userName) throws Exception {
		List<PassHistory> passList=null;

		try {
			passList=this.getPassHistoryDao().getPassHistory(userName);
		} catch (Exception e) {
			throw e;
		}
		return passList;
	}


	public List<PassHistory> getPassDetailsByPassId(Long id) throws Exception {
		List<PassHistory> passList=null;

		try {
			passList=this.getPassHistoryDao().getPassDetailsByPassId(id);
		} catch (Exception e) {
			throw e;
		}
		return passList;
	}


	public List<PassHistory> getPassHistoryByFilter(String userName, PassHistory passHistory) {
		List<PassHistory> passList=null;

		try {
			passList=this.getPassHistoryDao().getPassHistoryByFilter(userName,passHistory);
		} catch (Exception e) {
			throw e;
		}
		return passList;
	}

}
