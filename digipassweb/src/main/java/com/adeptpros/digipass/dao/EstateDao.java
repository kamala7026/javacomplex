package com.adeptpros.digipass.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.EstateDetails;
import com.adeptpros.digipass.entities.TEstateAdmin;
import com.adeptpros.digipass.entities.TEstateDetail;
import com.adeptpros.digipass.entities.TUsersLoginDetail;

@Component
public class EstateDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public EstateDetails getEstateDetails(String userName) throws Exception {
		System.out.println(userName);
		EstateDetails estateDetails=new EstateDetails();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();				
				TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
				if (estateAdmin!=null) {
					TEstateDetail estateDetail=estateAdmin.getTEstateDetail();
					estateDetails.setEntryPoints(estateDetail.getEstateEntryPoints());
					estateDetails.setEstateAddress(estateDetail.getEstateAddress1()+" ,</br> "+estateDetail.getEstateAddress2());
					estateDetails.setEstateCity(estateDetail.getEstateCity());
					estateDetails.setEstateCountry(estateDetail.getEstateCountry());
					estateDetails.setEstateDistrict(estateDetail.getEstateDistrict());
					estateDetails.setEstateId(estateDetail.getEstateId());
					estateDetails.setEstateName(estateDetail.getEstateName());
					estateDetails.setEstatePincode(estateDetail.getEstatePinCode());
					estateDetails.setEstateState(estateDetail.getEstateState());
					estateDetails.setEstateTitle(estateDetail.getEstateTitle());
					estateDetails.setEstateType(estateDetail.getEstateType());
					estateDetails.setExistPoints(estateDetail.getEstateExistPoints());	
					estateDetails.setAccountManager(estateAdmin.getEAdminFirstName()+" "+estateAdmin.getEAdminLastName());
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
		return estateDetails;
	}

}
