package com.adeptpros.digipass.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.Dashboard;
import com.adeptpros.digipass.entities.TEstateHost;
import com.adeptpros.digipass.entities.TPassDetail;

@Component
public class DashboardDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Dashboard getDashboardInfo(String userName) {
		Dashboard dashboard=new Dashboard();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();				
				List<TEstateHost> list=session.createQuery("from TEstateHost where TEstateAdmin.TUsersLoginDetail1.userName=:userName").setParameter("userName", userName).list();
				dashboard.setTotalHost(list.size());
				
				java.util.Date date= new java.util.Date();
				Timestamp currentTimeStamp=new Timestamp(date.getTime());
				
				/*List<TPassDetail> passDetailsList=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName =:userName and passApprovalStatus=2 and visitorEndTime > :currentTimeStamp" ).setParameter("userName", userName).setParameter("currentTimeStamp",currentTimeStamp ).list();
				int approvedPasses=passDetailsList.size();
				
				passDetailsList=null;
				passDetailsList=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName and passApprovalStatus=0 and visitorEndTime > :currentTimeStamp" ).setParameter("userName", userName).setParameter("currentTimeStamp",currentTimeStamp ).list();
				int pendingPasses=passDetailsList.size();
				
				passDetailsList=null;
				passDetailsList=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName and passApprovalStatus=1 and visitorEndTime > :currentTimeStamp" ).setParameter("userName",userName ).setParameter("currentTimeStamp",currentTimeStamp ).list();
				int updatedPasses=passDetailsList.size();
				*/
				List<TPassDetail> passDetailsList=null;				
				passDetailsList=session.createQuery("from TPassDetail where TEstateAdmin.TUsersLoginDetail1.userName =:userName and visitorEndTime > :currentTimeStamp" ).setParameter("userName", userName).setParameter("currentTimeStamp",currentTimeStamp ).list();
				int validPasses=passDetailsList.size();
				
				passDetailsList=null;
				passDetailsList=session.createQuery("from TPassDetail where  TEstateAdmin.TUsersLoginDetail1.userName =:userName and visitorEndTime <= :currentTimeStamp" ).setParameter("userName",userName).setParameter("currentTimeStamp",currentTimeStamp ).list();
				int expiredPasses=passDetailsList.size();
				
				passDetailsList=null;
				passDetailsList=session.createQuery("from TPassDetail where  TEstateAdmin.TUsersLoginDetail1.userName =:userName and visitorEntryTime is not null and visitorExistTime is not null" ).setParameter("userName",userName).list();
				int visitedPasses=passDetailsList.size();
				
				dashboard.setTotalPass(expiredPasses+validPasses);
				dashboard.setTotalVisited(visitedPasses);
				
				
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
		return dashboard;
	}
	
	

}
