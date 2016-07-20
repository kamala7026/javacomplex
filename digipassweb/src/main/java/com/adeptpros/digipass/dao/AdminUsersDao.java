package com.adeptpros.digipass.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn.TraceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.AdminUser;
import com.adeptpros.digipass.entities.TEstateAdmin;
import com.adeptpros.digipass.entities.TEstateDetail;
import com.adeptpros.digipass.entities.TEstateHost;
import com.adeptpros.digipass.entities.TRoleDetail;
import com.adeptpros.digipass.entities.TUsersLoginDetail;
import com.adeptpros.digipass.exception.MessageSendFailed;
import com.adeptpros.digipass.utility.MailUtil;
import com.adeptpros.digipass.utility.SMSUtil;
import com.adeptpros.digipass.utility.Utils;

@Component
public class AdminUsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public String registerAdminUser(AdminUser adminUser) {
		String status=null;
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				TUsersLoginDetail loginDetail=(TUsersLoginDetail) session.load(TUsersLoginDetail.class, new Long(1));
				
				TEstateDetail estateDetail=new TEstateDetail();
				estateDetail.setEstateAddress1(adminUser.getAddress());
				estateDetail.setEstateAddress2(adminUser.getAddressLine2());
				estateDetail.setEstateCity(adminUser.getCity());
				estateDetail.setEstateEmail(adminUser.getEmailId());
				estateDetail.setEstateEntryPoints(0);
				estateDetail.setEstateExistPoints(0);
				estateDetail.setEstateCountry("");
				estateDetail.setEstateDistrict("");
				estateDetail.setEstateMobileNo(adminUser.getMobile());
				estateDetail.setEstateName(adminUser.getCompanyName());
				estateDetail.setEstateTitle(adminUser.getCompanyName());
				estateDetail.setEstateOrganisation(adminUser.getCompanyName());
				estateDetail.setEstateState(adminUser.getState());
				estateDetail.setEstateType("");
				estateDetail.setEstatePinCode(adminUser.getPincode());
				estateDetail.setTUsersLoginDetail(loginDetail);				
				session.save(estateDetail);
				
				TUsersLoginDetail usersLoginDetail=new TUsersLoginDetail();
				usersLoginDetail.setActiveStatus(0);
				usersLoginDetail.setPassword(adminUser.getPassword());				
				TRoleDetail roleDetail=(TRoleDetail)session.load(TRoleDetail.class,new Long(2));
				usersLoginDetail.setTRoleDetail(roleDetail);
				usersLoginDetail.setUserName(adminUser.getEmailId());
				usersLoginDetail.setTUsersLoginDetail(loginDetail);
				session.save(usersLoginDetail);
				
				
				
				TEstateAdmin estateAdmin=new TEstateAdmin();
				estateAdmin.setEAdminFirstName(adminUser.getFirstName());
				estateAdmin.setEAdminLastName(adminUser.getLastName());
				estateAdmin.seteAdminAddress1(adminUser.getAddress());
				estateAdmin.setEAdminCity(adminUser.getCity());
				estateAdmin.setEAdminEmail(adminUser.getEmailId());
				estateAdmin.seteAdminPhoneNo1(adminUser.getMobile());
				estateAdmin.setEAdminState(adminUser.getState());
				estateAdmin.setEAdminPinCode(adminUser.getPincode());
				estateAdmin.setTEstateDetail(estateDetail);
				estateAdmin.setTUsersLoginDetail1(usersLoginDetail);
				estateAdmin.setTUsersLoginDetail2(loginDetail);
				
				session.save(estateAdmin);
				
				
				
				tx.commit();
				status="SUCCESS";
			}catch(Exception e){
				tx.rollback();
				e.printStackTrace();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
					
				}
			}
		}catch(Exception e){
			throw e;
		}
		
		return status;
	}
	@SuppressWarnings("unchecked")
	public String duplicateEmailCheck(String value) {
		String status=null;
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				List<TUsersLoginDetail> tUsersLoginDetails=session.createQuery("from TUsersLoginDetail where userName=:eAdminEmail").setParameter("eAdminEmail",value).list();
				if(tUsersLoginDetails.size()>=1){
					status="DUPLICATE";
				}else{
					status="NOTDUPLICATE";
				}
				tx.commit();
			}catch(Exception e){
				status="ERROR";
				throw e;
			}finally{
				try {
					session.close();						
				} catch (Exception e2) {
					status="ERROR";
					throw e2;
				}
			}
		}catch(Exception e){
			status="ERROR";
			throw e;
		}
		return status;
	}


	@SuppressWarnings("unchecked")
	public List<AdminUser> getAllAdminUserBySuperAdminUser(String userName) {
		List<AdminUser> adminUsers=new ArrayList<AdminUser>();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				List<TEstateAdmin> estateAdminList=session.createQuery("from TEstateAdmin where TUsersLoginDetail2.userName=:userName").setParameter("userName", userName).list();
				for (TEstateAdmin estateAdmin:estateAdminList) {
					
					AdminUser adminUser=new AdminUser();
					
					adminUser.setAdminUserId(estateAdmin.getEAdminId());
					if(estateAdmin.getTUsersLoginDetail1().getActiveStatus()==1){
						adminUser.setActiveStatus("Activated");
					}else if(estateAdmin.getTUsersLoginDetail1().getActiveStatus()==0){
						adminUser.setActiveStatus("Pending");
					}else if(estateAdmin.getTUsersLoginDetail1().getActiveStatus()==2){
						adminUser.setActiveStatus("Deactivated");
					}
					adminUser.setAddress(estateAdmin.geteAdminAddress1());
					adminUser.setCity(estateAdmin.getEAdminCity());
					adminUser.setCompanyName(estateAdmin.getTEstateDetail().getEstateName());
					adminUser.setCountry(estateAdmin.getEAdminCountry());
					adminUser.setCreatedDate(Utils.getStringFromTimeStamp1(estateAdmin.getCreatedDate()));
					adminUser.setDistrict(estateAdmin.getEAdminDistrict());
					adminUser.setEmailId(estateAdmin.getEAdminEmail());
					adminUser.setFirstName(estateAdmin.getEAdminFirstName());
					adminUser.setLastName(estateAdmin.getEAdminLastName());
					adminUser.setMobile(estateAdmin.geteAdminPhoneNo1());
					adminUser.setPincode(estateAdmin.getEAdminPinCode());
					adminUser.setState(estateAdmin.getEAdminState());
					adminUsers.add(adminUser);
				}
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
		return adminUsers;
	}


	@SuppressWarnings("unchecked")
	public String setAccess(AdminUser adminUser) throws Exception {
		String status=null;
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				int count=0;
				List<Long> list = Arrays.asList(adminUser.getAdminUserIdList());
				List<TEstateAdmin> estateAdminList=session.createQuery("from TEstateAdmin where eAdminId in (:eAdminId)").setParameterList("eAdminId", list).list();
				
				for(TEstateAdmin estateAdmin:estateAdminList){					
					count++;
					TUsersLoginDetail loginDetail=estateAdmin.getTUsersLoginDetail1();
					if(adminUser.getAction().equals("ACTIVE")){
						loginDetail.setActiveStatus(1);
						session.update(loginDetail);					
						String message="Hello "+estateAdmin.getEAdminFirstName()+" "+estateAdmin.getEAdminLastName()+" , Thank you for registering with DigiPass. Your account has been authenticated and is now Active. You can login to with the below credentials: Email ID: "+estateAdmin.getEAdminEmail()+" Password: "+loginDetail.getPassword()+" Thank You.";
						String status1=SMSUtil.sendSMS("+91"+estateAdmin.geteAdminPhoneNo1(), message);
						System.out.println(status1);
						if(status1.equals("success")){								
							String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
								+ "<div><h2 style='color:blue'>Welcome to Digipass</h2>"+
										"<p>Hello <b>"+estateAdmin.getEAdminFirstName()+" "+estateAdmin.getEAdminLastName()+"</b>"
												+ ", </br> Thank you for registering with DigiPass. Your account has been authenticated and is now Active. You can login to with the below credentials:<br/>"+
										
										"<p><b>Email ID: </b>"+estateAdmin.getEAdminEmail()+"</p></br>"+
										"<p><b>Password: </b>"+loginDetail.getPassword()+"</p></br></br></br></br>"
												+ "<p><b>DigiPass Team</b></p>";
							
							boolean s=MailUtil.sendMail(estateAdmin.getEAdminEmail(),emailMessage,"Digipass");				
							if(s){								
								tx.commit();
								status="SUCCESS";
								if(count!=estateAdminList.size()){
									tx=session.getTransaction();
									tx.begin();
								}
							}else{
								status="Mail sending ERROR";
								tx.rollback();
								return status;
							}
					}else{
						System.out.println(status);
						throw new MessageSendFailed("Message sending failed");					
					}
					}else if(adminUser.getAction().equals("DEACTIVE")){
						loginDetail.setActiveStatus(2);
						session.update(loginDetail);					
						String message="Hello "+estateAdmin.getEAdminFirstName()+" "+estateAdmin.getEAdminLastName()+" , Your digipass account has been deactivated and now you can't access your account. Please contact digipass support team in case of any queries.";
						String status1=SMSUtil.sendSMS("+91"+estateAdmin.geteAdminPhoneNo1(), message);
						System.out.println(status1);
						if(status1.equals("success")){								
							String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
								+ "<div><h2 style='color:blue'>Welcome to Digipass</h2>"+
										"<p>Hello <b>"+estateAdmin.getEAdminFirstName()+" "+estateAdmin.getEAdminLastName()+"</b>"
												+ ", </br>Your digipass account has been deactivated and now you can't access your account. Please contact digipass support team in case of any queries."
										+"</p></br></br></br></br>"
										+ "<p><b>DigiPass Team</b></p>";
							
							boolean s=MailUtil.sendMail(estateAdmin.getEAdminEmail(),emailMessage,"Digipass");				
							if(s){								
								tx.commit();
								status="SUCCESS";
								if(count!=estateAdminList.size()){
									tx=session.getTransaction();
									tx.begin();
								}
							}else{
								status="Mail sending ERROR";
								tx.rollback();
								return status;
							}
					}else{
						System.out.println(status);
						throw new MessageSendFailed("Message sending failed");					
					}
					}						
			    }
			}catch(Exception e){
				status="ERROR";
				tx.rollback();
				e.printStackTrace();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					status="ERROR";
					tx.rollback();
					throw e2;
					
				}
			}
		}catch(Exception e){
			status="ERROR";
			throw e;
		}
		return status;
	}


	public AdminUser getAdminUser(String userName) {
		AdminUser adminUser=new AdminUser();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName", userName).uniqueResult();
					adminUser.setAdminUserId(estateAdmin.getEAdminId());
					if(estateAdmin.getTUsersLoginDetail1().getActiveStatus()==1){
						adminUser.setActiveStatus("Activated");
					}else if(estateAdmin.getTUsersLoginDetail1().getActiveStatus()==0){
						adminUser.setActiveStatus("Pending");
					}else if(estateAdmin.getTUsersLoginDetail1().getActiveStatus()==2){
						adminUser.setActiveStatus("Deactivated");
					}
					adminUser.setAddress(estateAdmin.geteAdminAddress1());
					adminUser.setAddressLine2(estateAdmin.geteAdminAddress2());
					adminUser.setCity(estateAdmin.getEAdminCity());
					adminUser.setCompanyName(estateAdmin.getTEstateDetail().getEstateName());
					adminUser.setCountry(estateAdmin.getEAdminCountry());
					adminUser.setCreatedDate(Utils.getStringFromTimeStamp1(estateAdmin.getCreatedDate()));
					adminUser.setDistrict(estateAdmin.getEAdminDistrict());
					adminUser.setEmailId(estateAdmin.getEAdminEmail());
					adminUser.setFirstName(estateAdmin.getEAdminFirstName());
					adminUser.setLastName(estateAdmin.getEAdminLastName());
					adminUser.setMobile(estateAdmin.geteAdminPhoneNo1());
					adminUser.setPincode(estateAdmin.getEAdminPinCode());
					adminUser.setState(estateAdmin.getEAdminState());					
				
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
		return adminUser;
	}


	public String updateAdminUser(AdminUser adminUser) {
		String status=null;
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				//TUsersLoginDetail loginDetail=(TUsersLoginDetail) session.load(TUsersLoginDetail.class, new Long(1));
				TEstateAdmin estateAdmin=(TEstateAdmin)session.get(TEstateAdmin.class, new Long(adminUser.getAdminUserId()));
				
				
				TEstateDetail estateDetail=estateAdmin.getTEstateDetail();
				estateDetail.setEstateAddress1(adminUser.getAddress());
				estateDetail.setEstateAddress2(adminUser.getAddressLine2());
				estateDetail.setEstateCity(adminUser.getCity());
				estateDetail.setEstateEmail(adminUser.getEmailId());
				estateDetail.setEstateEntryPoints(0);
				estateDetail.setEstateExistPoints(0);
				estateDetail.setEstateCountry("");
				estateDetail.setEstateDistrict("");
				estateDetail.setEstateMobileNo(adminUser.getMobile());
				estateDetail.setEstateName(adminUser.getCompanyName());
				estateDetail.setEstateTitle(adminUser.getCompanyName());
				estateDetail.setEstateOrganisation(adminUser.getCompanyName());
				estateDetail.setEstateState(adminUser.getState());
				estateDetail.setEstateType("");
				estateDetail.setEstatePinCode(adminUser.getPincode());
				//estateDetail.setTUsersLoginDetail(loginDetail);				
				session.update(estateDetail);
				
				TUsersLoginDetail usersLoginDetail=estateAdmin.getTUsersLoginDetail1();				
				usersLoginDetail.setUserName(adminUser.getEmailId());
				session.update(usersLoginDetail);
								
				estateAdmin.setEAdminFirstName(adminUser.getFirstName());
				estateAdmin.setEAdminLastName(adminUser.getLastName());
				estateAdmin.seteAdminAddress1(adminUser.getAddress());
				estateAdmin.seteAdminAddress2(adminUser.getAddressLine2());
				estateAdmin.setEAdminCity(adminUser.getCity());
				estateAdmin.setEAdminEmail(adminUser.getEmailId());
				estateAdmin.seteAdminPhoneNo1(adminUser.getMobile());
				estateAdmin.setEAdminState(adminUser.getState());
				estateAdmin.setEAdminPinCode(adminUser.getPincode());
								
				session.update(estateAdmin);
								
				tx.commit();
				status="SUCCESS";
			}catch(Exception e){
				status="ERROR";
				tx.rollback();
				e.printStackTrace();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					status="ERROR";
					tx.rollback();
					throw e2;
					
				}
			}
		}catch(Exception e){
			status="ERROR";
			throw e;
		}
		
		return status;
	}

}
