package com.adeptpros.digipass.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.PassHistory;
import com.adeptpros.digipass.entities.TEstateAdmin;
import com.adeptpros.digipass.entities.TEstateDetail;
import com.adeptpros.digipass.entities.TEstateHost;
import com.adeptpros.digipass.entities.TPassDetail;
import com.adeptpros.digipass.utility.Utils;
@Component
public class PassHistoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	public List<PassHistory> getPassHistory(String userName) throws Exception {
		List<PassHistory> passList=new ArrayList<PassHistory>();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				//TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
				//TEstateDetail estateDetail=estateAdmin.getTEstateDetail();
				List<TPassDetail> passDetail=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).list();
				for(TPassDetail tPassDetail:passDetail){
					PassHistory passHistory=new PassHistory();
					passHistory.setCompanyName(tPassDetail.getVisitorCompanyName());
					passHistory.setCreatedBy(tPassDetail.getTEstateAdmin().getEAdminFirstName()+" "+tPassDetail.getTEstateAdmin().getEAdminLastName());
					passHistory.setCreatedDate(tPassDetail.getCreatedDate().toString().substring(0,10));
					passHistory.setHostId(tPassDetail.getTEstateHost().getEHostId());
					passHistory.setHostFirstName(tPassDetail.getTEstateHost().getEHostFirstName());
					passHistory.setHostLastName(tPassDetail.getTEstateHost().getEHostLastName());
					passHistory.setHostEmail(tPassDetail.getTEstateHost().geteHostEmail1());
					passHistory.setHostMobile(tPassDetail.getTEstateHost().geteHostPhoneNo1());
					
					passHistory.setVisitorVechilesDetails(tPassDetail.getVisitorVechilesDetails());
					passHistory.setVisitorEquipmentDetails(tPassDetail.getVisitorEquipmentDetails());
					passHistory.setEstateId(tPassDetail.getTEstateDetail().getEstateId());
					passHistory.setEstateName(tPassDetail.getTEstateDetail().getEstateName());
					passHistory.setPassId(tPassDetail.getPassId());
					java.util.Date date= new java.util.Date();
					Timestamp currentTimeStamp=new Timestamp(date.getTime());
					String s=isValidPass(currentTimeStamp,tPassDetail.getVisitorEndTime());
					passHistory.setPassStatus(s);
					passHistory.setVisitorAddress(tPassDetail.getVisitorAddress());
					passHistory.setVisitorEmailId(tPassDetail.getVisitorEmailId());
					passHistory.setVisitorEndTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorEndTime()));
					passHistory.setVisitorStartTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorStartTime()));
					if(tPassDetail.getVisitorExistTime()!=null)
					passHistory.setVisitorExitTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorExistTime()));
					if(tPassDetail.getVisitorEntryTime()!=null)
					passHistory.setVisitorEntryTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorEntryTime()));
					passHistory.setVisitorInstruction(tPassDetail.getVisitorInstruction());
					passHistory.setVisitorMobileNo(tPassDetail.getVisitorMobNo());
					passHistory.setVisitorFirstName(tPassDetail.getVisitorFirstName());
					passHistory.setVisitorLastName(tPassDetail.getVisitorLastName());
					passHistory.setVisitorPurpose(tPassDetail.getVisitorPurpose());
					passHistory.setVisitorVanue(tPassDetail.getVisitorVanue());
					passList.add(passHistory);
					
				}
				tx.commit();
			}catch(Exception e){
				throw e;
			}finally{
				try {
					session.close();						
				} catch (Exception e2) {
					throw e2;
				}
			}
		}catch(Exception e){
			throw e;
		}
		Collections.sort(passList);
		return passList;
	}
	public String isValidPass(Timestamp t1, Timestamp t2) {
		int i=Utils.compareTimeStamp(t1, t2);
		String s="";
		if(i==1){
			s="VALID";
		}else{
			s="EXPIRED";
		}
		return s;
	}


	@SuppressWarnings("unchecked")
	public List<PassHistory> getPassDetailsByPassId(Long id) throws Exception {
		List<PassHistory> passList=new ArrayList<PassHistory>();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();				
				List<TPassDetail> passDetail=session.createQuery("from TPassDetail where passId=:passId").setParameter("passId",id).list();
				for(TPassDetail tPassDetail:passDetail){
					PassHistory passHistory=new PassHistory();
					passHistory.setCompanyName(tPassDetail.getVisitorCompanyName());
					passHistory.setCreatedBy(tPassDetail.getTEstateAdmin().getEAdminFirstName()+" "+tPassDetail.getTEstateAdmin().getEAdminLastName());
					passHistory.setCreatedDate(Utils.getStringFromTimeStamp1(tPassDetail.getCreatedDate()));
					passHistory.setHostId(tPassDetail.getTEstateHost().getEHostId());
					passHistory.setHostFirstName(tPassDetail.getTEstateAdmin().getEAdminFirstName());
					passHistory.setHostLastName(tPassDetail.getTEstateAdmin().getEAdminLastName());
					passHistory.setVisitorVechilesDetails(tPassDetail.getVisitorVechilesDetails());
					passHistory.setVisitorEquipmentDetails(tPassDetail.getVisitorEquipmentDetails());
					passHistory.setEstateId(tPassDetail.getTEstateDetail().getEstateId());
					passHistory.setEstateName(tPassDetail.getTEstateDetail().getEstateName());
					passHistory.setPassId(tPassDetail.getPassId());
					java.util.Date date= new java.util.Date();
					Timestamp currentTimeStamp=new Timestamp(date.getTime());
					String s=isValidPass(currentTimeStamp,tPassDetail.getVisitorEndTime());
					passHistory.setPassStatus(s);
					passHistory.setVisitorAddress(tPassDetail.getVisitorAddress());
					passHistory.setVisitorEmailId(tPassDetail.getVisitorEmailId());
					passHistory.setVisitorEndTime(Utils.getStringFromTimeStamp(tPassDetail.getVisitorEndTime()));
					passHistory.setVisitorStartTime(Utils.getStringFromTimeStamp(tPassDetail.getVisitorStartTime()));
					if(tPassDetail.getVisitorExistTime()!=null)
						passHistory.setVisitorExitTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorExistTime()));
					if(tPassDetail.getVisitorEntryTime()!=null)
						passHistory.setVisitorEntryTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorEntryTime()));
					passHistory.setVisitorInstruction(tPassDetail.getVisitorInstruction());
					passHistory.setVisitorMobileNo(tPassDetail.getVisitorMobNo());
					passHistory.setVisitorFirstName(tPassDetail.getVisitorFirstName());
					passHistory.setVisitorLastName(tPassDetail.getVisitorLastName());
					passHistory.setVisitorPurpose(tPassDetail.getVisitorPurpose());
					passHistory.setVisitorVanue(tPassDetail.getVisitorVanue());
					passList.add(passHistory);
					
				}
				tx.commit();
			}catch(Exception e){
				throw e;
			}finally{
				try {
					session.close();						
				} catch (Exception e2) {
					throw e2;
				}
			}
		}catch(Exception e){
			throw e;
		}
		return passList;
	}


	@SuppressWarnings("unchecked")
	public List<PassHistory> getPassHistoryByFilter(String userName, PassHistory passHistory2) {
		List<PassHistory> passList=new ArrayList<PassHistory>();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			System.out.println(passHistory2.getFromDate()+"============"+passHistory2.getToDate());
			try {
				tx.begin();
				/*TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
				TEstateDetail estateDetail=estateAdmin.getTEstateDetail();
				List<TPassDetail> passDetail=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).list();
				*/
				List<TPassDetail> passDetail=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName=:userName and createdDate BETWEEN :fromDate and :toDate").setParameter("userName",userName).setDate("fromDate",passHistory2.getFromDate()).setDate("toDate",passHistory2.getToDate()).list();
				System.out.println(passDetail.size());
				for(TPassDetail tPassDetail:passDetail){
					PassHistory passHistory=new PassHistory();
					System.out.println(tPassDetail.getCreatedDate());
					passHistory.setCompanyName(tPassDetail.getVisitorCompanyName());
					passHistory.setCreatedBy(tPassDetail.getTEstateAdmin().getEAdminFirstName()+" "+tPassDetail.getTEstateAdmin().getEAdminLastName());
					passHistory.setCreatedDate(tPassDetail.getCreatedDate().toString().substring(0,10));
					passHistory.setHostId(tPassDetail.getTEstateHost().getEHostId());
					passHistory.setHostFirstName(tPassDetail.getTEstateAdmin().getEAdminFirstName());
					passHistory.setHostLastName(tPassDetail.getTEstateAdmin().getEAdminLastName());
					passHistory.setVisitorVechilesDetails(tPassDetail.getVisitorVechilesDetails());
					passHistory.setVisitorEquipmentDetails(tPassDetail.getVisitorEquipmentDetails());
					passHistory.setEstateId(tPassDetail.getTEstateDetail().getEstateId());
					passHistory.setEstateName(tPassDetail.getTEstateDetail().getEstateName());
					passHistory.setPassId(tPassDetail.getPassId());
					java.util.Date date= new java.util.Date();
					Timestamp currentTimeStamp=new Timestamp(date.getTime());
					String s=isValidPass(currentTimeStamp,tPassDetail.getVisitorEndTime());
					passHistory.setPassStatus(s);
					passHistory.setVisitorAddress(tPassDetail.getVisitorAddress());
					passHistory.setVisitorEmailId(tPassDetail.getVisitorEmailId());
					if(tPassDetail.getVisitorExistTime()!=null)
					passHistory.setVisitorEndTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorExistTime()));
					if(tPassDetail.getVisitorEntryTime()!=null)
					passHistory.setVisitorStartTime(Utils.getStringFromTimeStamp1(tPassDetail.getVisitorEntryTime()));
					passHistory.setVisitorInstruction(tPassDetail.getVisitorInstruction());
					passHistory.setVisitorMobileNo(tPassDetail.getVisitorMobNo());
					passHistory.setVisitorFirstName(tPassDetail.getVisitorFirstName());
					passHistory.setVisitorLastName(tPassDetail.getVisitorLastName());
					
					passList.add(passHistory);
					
				}
				tx.commit();
			}catch(Exception e){
				throw e;
			}finally{
				try {
					session.close();						
				} catch (Exception e2) {
					throw e2;
				}
			}
		}catch(Exception e){
			throw e;
		}
		Collections.sort(passList);
		return passList;
	}

}
