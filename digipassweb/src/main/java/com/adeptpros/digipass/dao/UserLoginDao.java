package com.adeptpros.digipass.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.ChangePassword;
import com.adeptpros.digipass.beans.UserLogin;
import com.adeptpros.digipass.entities.TEstateAdmin;
import com.adeptpros.digipass.entities.TEstateDetail;
import com.adeptpros.digipass.entities.TUsersLoginDetail;
import com.adeptpros.digipass.exception.InvalidPassword;
import com.adeptpros.digipass.exception.InvalidUser;
import com.adeptpros.digipass.exception.MessageSendFailed;
import com.adeptpros.digipass.utility.MailUtil;
import com.adeptpros.digipass.utility.SMSUtil;
import com.adeptpros.digipass.utility.Utils;
@Component
public class UserLoginDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserLogin userLogin(UserLogin userLogin) throws Exception {
		UserLogin userLogin2=new UserLogin();
		try {
			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				//TUsersLoginDetail login=(TUsersLoginDetail) session.get(TUsersLoginDetail.class, userLogin.getUserName());
				//Query query=session.createQuery("from TUsersLoginDetail where userName = :userName").setParameter("userName", userLogin.getUserName());
				//TUsersLoginDetail login=(TUsersLoginDetail)query.uniqueResult();
				
				Criteria criteria = session.createCriteria(TUsersLoginDetail.class);
				criteria.add(Restrictions.eq("userName", userLogin.getUserName()));
				TUsersLoginDetail login = (TUsersLoginDetail) criteria.uniqueResult();
				//System.out.println(login.getUserName());
				if(login==null){
					throw new InvalidUser("Invalid User");
				}else{
					System.out.println(login.getTRoleDetail().getRoleId());
					if(login.getTRoleDetail().getRoleId()>2 ){
						userLogin2.setLoginStatus("NOTALOW");
					}else if(login.getActiveStatus()!=1){
						userLogin2.setLoginStatus("NOTACTIVE");
					}else if(!login.getPassword().equals(userLogin.getPassword())){
						throw new InvalidPassword("Invalid password");						
					}else{
						userLogin2.setUserName(login.getUserName());
						userLogin2.setUserId(login.getUserId());
						userLogin2.setRoleId(login.getTRoleDetail().getRoleId());
						
						if(login.getTRoleDetail().getRoleId()==2){
							userLogin2.setName(login.getTEstateAdmins1().getEAdminFirstName()+" "+login.getTEstateAdmins1().getEAdminLastName());
							userLogin2.setCompanyName(login.getTEstateAdmins1().getTEstateDetail().getEstateName());
						}else if(login.getTRoleDetail().getRoleId()==4){
							userLogin2.setName(login.getTEstateGateMans1().geteGateManFirstName()+" "+login.getTEstateGateMans1().geteGateManLastName());
							userLogin2.setCompanyName(login.getTEstateGateMans1().getTEstateDetail().getEstateName());
						}else if(login.getTRoleDetail().getRoleId()==3){
							userLogin2.setName(login.getTEstateHosts1().getEHostFirstName()+" "+login.getTEstateHosts1().getEHostLastName());
							userLogin2.setCompanyName(login.getTEstateHosts1().getTEstateDetail().getEstateName());
						}else if(login.getTRoleDetail().getRoleId()==1){
							userLogin2.setName("Administrator");
							userLogin2.setCompanyName("Adeptpros IT Solution");
						}						
						userLogin2.setLoginStatus("VALIDED");
					}
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
		return userLogin2;
	}

	public String changePassword(ChangePassword changePassword) throws Exception {
		String status="";
		try {
				SessionFactory sessionFactory = getSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tx = session.getTransaction();
				try {
					tx.begin();
				/*	Criteria criteria = session.createCriteria(TUsersLoginDetail.class);
					criteria.add(Restrictions.eq("userName", cah.getUserName()));*/
					TUsersLoginDetail login = (TUsersLoginDetail)session.get(TUsersLoginDetail.class, changePassword.getUserId());
					login.setPassword(changePassword.getNewPassword());
					session.update(login);
					tx.commit();
					status="SUCCESS";
					
				}catch(Exception e){
					tx.rollback();
					status="ERROR";
					throw e;
				}finally{
					try {
						session.close();						
					} catch (Exception e2) {
						tx.rollback();
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

	public String forgetPassword(UserLogin userLogin) throws Exception {
		String status="";
		String newPassword="";
		try {
				SessionFactory sessionFactory = getSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tx = session.getTransaction();
				try {
					tx.begin();
					System.out.println(userLogin.getUserName());
					Criteria criteria = session.createCriteria(TUsersLoginDetail.class);
					criteria.add(Restrictions.eq("userName", userLogin.getUserName()));
					TUsersLoginDetail login = (TUsersLoginDetail) criteria.uniqueResult();
					System.out.println(login.getUserName());
					if(login==null){
						throw new InvalidUser("Invalid User");
					}else{
						newPassword=Utils.randomString();
						login.setPassword(newPassword);
						
						
						TEstateAdmin estateAdmin2=login.getTEstateAdmins1();
						/*TEstateDetail tEstateDetail=login.getTEstateAdmins1().getTEstateDetail();*/
						
						String message="Hello "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" , a temporary password has been generated for you. Please login on the CRM using below credentials: Email ID: "+login.getUserName()+" , Password: "+newPassword;
						String status1=SMSUtil.sendSMS("+91"+estateAdmin2.geteAdminPhoneNo1(), message);
						System.out.println(status1);
						if(status1.equals("success")){								
							String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
								+ "<div>"+
										"<p>Hello <b>"+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+"</b>, "
												+ "</br> A temporary password has been generated for you. Please login on the CRM using below credentials: "
												+ "Email ID: "+login.getUserName()+" , Password: "+newPassword;
												
							
							boolean s=MailUtil.sendMail(login.getUserName(),emailMessage,"Digipass");							
							if(s){
								session.update(login);
								tx.commit();
								status="SUCCESS";
							}else{
								tx.rollback();
								status="ERROR";
							}
						}else{
							System.out.println(status);
							tx.rollback();
							status="ERROR";
							throw new MessageSendFailed("Message sending failed");
							
						}	
						
						/*String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
								+ "<div> Hello "+login.getTEstateHosts1().getEHostFirstName()+" "+login.getTEstateHosts1().getEHostLastName()+
										"<p>Your Digipass login password has been reset </p>"+
										"Your new password :  <b>"+newPassword+"</b>";
										
										
						boolean s=MailUtil.sendMail(userLogin.getUserName(),emailMessage ,"Reset Password from Digipass");
						if(s){
							session.update(login);
							tx.commit();
							status="SUCCESS";
						}else{
							tx.rollback();
							status="ERROR";
						}*/
						
					}
					
					
				}catch(Exception e){
					tx.rollback();
					status="ERROR";
					throw e;
				}finally{
					try {
						session.close();						
					} catch (Exception e2) {
						tx.rollback();
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

}