package com.adeptpros.digipass.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn.TraceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;

import com.adeptpros.digipass.beans.HostUsers;
import com.adeptpros.digipass.entities.TEstateAdmin;
import com.adeptpros.digipass.entities.TEstateDetail;
import com.adeptpros.digipass.entities.TEstateHost;
import com.adeptpros.digipass.entities.TRoleDetail;
import com.adeptpros.digipass.entities.TUsersLoginDetail;
import com.adeptpros.digipass.exception.DateTimeFormatException;
import com.adeptpros.digipass.exception.MessageSendFailed;

import au.com.bytecode.opencsv.CSVReader;


import com.adeptpros.digipass.utility.MailUtil;
import com.adeptpros.digipass.utility.SMSUtil;
import com.adeptpros.digipass.utility.Utils;
@Component
public class HostUsersDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<HostUsers> getAllUsersByAdminId(String userName) throws Exception {
		List<HostUsers> estateUsersList=new ArrayList<HostUsers>();
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
				List<TEstateHost> estateHostList=estateAdmin.getTEstateHosts();
				System.out.println("total host: "+estateHostList.size());
				//List<TEstateGateMan> estateGateMansList=estateAdmin.getTEstateGateMans();
				
				if(estateHostList!=null && estateHostList.size()!=0){
					for (TEstateHost host: estateHostList) {
						HostUsers hostUsers=new HostUsers();
						hostUsers.setHostUserId(host.getEHostId());
						hostUsers.setCreatedDate(host.getCreatedDate().toString());
						hostUsers.setFirstName(host.getEHostFirstName());
						hostUsers.setLastName(host.getEHostLastName());
						hostUsers.setAddressLine1(host.geteHostAddress1());
						hostUsers.setAddressLine2(host.geteHostAddress2());
						hostUsers.setCity(host.getEHostCity());
						hostUsers.setEmail1(host.geteHostEmail1());
						hostUsers.setEmail2(host.geteHostEmail2());
						hostUsers.setPhoneNo1(host.geteHostPhoneNo1());
						hostUsers.setPhoneNo2(host.geteHostPhoneNo2());
						hostUsers.setState(host.getEHostState());
						hostUsers.setPincode(host.getEHostPinCode());
						hostUsers.setCreatedDate(Utils.getStringFromTimeStamp1(host.getCreatedDate()));
						hostUsers.setExpiredDate(Utils.getStringFromTimeStamp1(host.getExpiredDate()));
						hostUsers.setUserType(host.geteHostType());
						hostUsers.setDepartment(host.geteHostDepartment());
						if(host.getGrantAccess()==1){							
							hostUsers.setActiveStatus("Activated");							
						}
						if(host.getGrantAccess()==0){
							hostUsers.setActiveStatus("Deactivated");
						}
						if(host.getUserStatus()==3){
							hostUsers.setActiveStatus("Disabled");
						}else if(host.getUserStatus()==0  && host.getActiveStatus()==0 && host.getGrantAccess()==0){
							hostUsers.setActiveStatus("Added");
						}else if(host.getUserStatus()==1  && host.getActiveStatus()==0 && host.getGrantAccess()==1){
							hostUsers.setActiveStatus("Invited");
						}
						
						hostUsers.setHostUserId(host.getEHostId());
						//estateUsers.setUserType("Host");
						estateUsersList.add(hostUsers);
					}
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
		Collections.sort(estateUsersList);
		return estateUsersList;
	}


	public HostUsers addHostUser(String userName, HostUsers hostUser) throws Exception {
		System.out.println(userName);
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				TUsersLoginDetail usersLoginDetail1=(TUsersLoginDetail)session.createQuery("from TUsersLoginDetail where userName=:userName").setParameter("userName",hostUser.getEmail1()).uniqueResult();
				if(usersLoginDetail1!=null){
					hostUser.setStatus("EXISTUSER");
					return hostUser;
				}	
				System.out.println(userName);
				TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
				long estateId=estateAdmin.getTEstateDetail().getEstateId();
				long adminId=estateAdmin.getEAdminId();
				TUsersLoginDetail usersLoginDetail=new TUsersLoginDetail();
				usersLoginDetail.setActiveStatus(1);
				String password=Utils.randInt()+"";
				usersLoginDetail.setPassword(password);
				
				TRoleDetail roleDetail=(TRoleDetail)session.load(TRoleDetail.class,new Long(3));
				usersLoginDetail.setTRoleDetail(roleDetail);
				
				usersLoginDetail.setUserName(hostUser.getEmail1());
				
				
				TUsersLoginDetail userDetail=(TUsersLoginDetail)session.get(TUsersLoginDetail.class, estateAdmin.getTUsersLoginDetail1().getUserId());
				usersLoginDetail.setTUsersLoginDetail(userDetail);
				session.save(usersLoginDetail);
				
				TEstateHost tEstateHost=new TEstateHost();
				tEstateHost.seteHostAddress1(hostUser.getAddressLine1());
				tEstateHost.seteHostAddress2(hostUser.getAddressLine2());
				tEstateHost.setEHostCity(hostUser.getCity());
				tEstateHost.setEHostDistrict(hostUser.getDistrict());
				tEstateHost.seteHostEmail1(hostUser.getEmail1());
				tEstateHost.seteHostEmail2(hostUser.getEmail2());
				tEstateHost.setEHostFirstName(hostUser.getFirstName());
				tEstateHost.setEHostLastName(hostUser.getLastName());
				tEstateHost.seteHostPhoneNo1(hostUser.getPhoneNo1());
				tEstateHost.seteHostPhoneNo2(hostUser.getPhoneNo2());
				tEstateHost.setEHostPinCode(hostUser.getPincode());
				tEstateHost.setEHostState(hostUser.getState());
				String expiryDate=hostUser.getExpiredDate()+hostUser.getExpiredTime().replaceAll("\\s+","");
				tEstateHost.setExpiredDate(Utils.getStringToTimeStamp(expiryDate));
				//tEstateHost.setValidFrom(Utils.getStringToTimeStamp(hostUser.getValidFrom()));
				tEstateHost.seteHostType(hostUser.getUserType());
				tEstateHost.seteHostDepartment(hostUser.getDepartment());
				tEstateHost.setBuildingNo(hostUser.getBuidingNo());
				tEstateHost.setGrantAccess(0);
				tEstateHost.setUserStatus(0);
				tEstateHost.setActiveStatus(0);
				
				tEstateHost.setTUsersLoginDetail1(usersLoginDetail);
				tEstateHost.setTUsersLoginDetail2(userDetail);
				
				TEstateDetail tEstateDetail=(TEstateDetail)session.load(TEstateDetail.class, estateId);
				tEstateHost.setTEstateDetail(tEstateDetail);
				
				TEstateAdmin estateAdmin2=(TEstateAdmin)session.load(TEstateAdmin.class, adminId);
				tEstateHost.setTEstateAdmin(estateAdmin2);
				
				session.save(tEstateHost);				
				tx.commit();
				hostUser.setStatus("SUCCESS");				
			}catch(Exception e){
				hostUser.setStatus("ERROR");
				throw e;
			}finally{
				try {
					session.close();						
				} catch (Exception e2) {
					hostUser.setStatus("ERROR");
					throw e2;
				}
			}
		}catch(Exception e){
			hostUser.setStatus("ERROR");
			throw e;
		}
		
		return hostUser;
	}


	@SuppressWarnings("unchecked")
	public String setAccess(HostUsers hostUser) throws Exception {
		String status="";
		try {			
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				List<Long> list = Arrays.asList(hostUser.getHostUserIdList());
				List<TEstateHost> estateHost=session.createQuery("from TEstateHost where eHostId in (:hostId)").setParameterList("hostId", list).list();
				int count=0;
				if(hostUser.getAction().equals("INVITED")){
					for (TEstateHost host:estateHost) {
						count++;
							host.setActiveStatus(0);		
							host.setUserStatus(1);
							host.setGrantAccess(1);
							TEstateAdmin estateAdmin2=host.getTEstateAdmin();
							TEstateDetail tEstateDetail=host.getTEstateDetail();
							
							String message="Hello "+host.getEHostFirstName()+" "+host.getEHostLastName()+" , You have been authorized by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
									tEstateDetail.getEstateName()+ "  to use the DigiPass App for your visitor management. Please login on the App with below credentials. Email Id:  "+host.geteHostEmail1()+" , Password: "+host.getTUsersLoginDetail1().getPassword();
							String status1=SMSUtil.sendSMS("+91"+host.geteHostPhoneNo1(), message);
							System.out.println(status1);
							if(status1.equals("success")){								
								String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
									+ "<div><h2 style='color:blue'>Welcome to Digipass</h2>"+
											"<p>Hello <b>"+host.getEHostFirstName()+" "+host.getEHostLastName()+"</b>"
													+ ", </br> You have been authorized by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+", "+
													tEstateDetail.getEstateName()+ "  to use the DigiPass App for your visitor management.</p>"
													+ "<p>Please login on the App with below credentials:</p><br/>"+
											
											"<p><b>Email ID: </b>"+host.geteHostEmail1()+"</p></br>"+
											"<p><b>Password: </b>"+host.getTUsersLoginDetail1().getPassword()+"</p></br></br></br></br>"
													+ "<p><b>DigiPass Team</b></p>";
								
								boolean s=MailUtil.sendMail(host.geteHostEmail1(),emailMessage,"Digipass");
							
							
								if(s){								
									tx.commit();
									status="SUCCESS";
									if(count!=estateHost.size()){
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
				}else if(hostUser.getAction().equals("GRANTACCESS"))
					for (TEstateHost host:estateHost) {
						count++;
						System.out.println(count);
											
							host.setGrantAccess(1);
							host.setActiveStatus(1);
							host.setUserStatus(1);						
							
							TEstateAdmin estateAdmin2=host.getTEstateAdmin();
							TEstateDetail tEstateDetail=host.getTEstateDetail();
							
							String message="Hello "+host.getEHostFirstName()+" "+host.getEHostLastName()+" , Your access for Pass creation has been activated again by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
									tEstateDetail.getEstateName()+ ". Now You can login on the App and can create new passes.";
							String status1=SMSUtil.sendSMS("+91"+host.geteHostPhoneNo1(), message);
							System.out.println(status1);
							if(status1.equals("success")){								
								String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
									+ "<div>"+
											"<p>Hello <b>"+host.getEHostFirstName()+" "+host.getEHostLastName()+"</b>"
													+ ",</br>  Your access for Pass creation has been activated again by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
													tEstateDetail.getEstateName()+ ".  Now You can login on the App and can create new passes.</p></br></br>"
															+ "<p>DigiPass Team.</p>";
													
								
								boolean s=MailUtil.sendMail(host.geteHostEmail1(),emailMessage,"Digipass");							
								if(s){								
									tx.commit();
									status="SUCCESS";
									if(count!=estateHost.size()){
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
			  }else if(hostUser.getAction().equals("CANCEL"))
					for (TEstateHost host:estateHost) {
						count++;
						host.setGrantAccess(0);
						host.setActiveStatus(0);
						TEstateAdmin estateAdmin2=host.getTEstateAdmin();
						TEstateDetail tEstateDetail=host.getTEstateDetail();
						
						String message="Hello "+host.getEHostFirstName()+" "+host.getEHostLastName()+" , Your access for Pass creation has been revoked by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
								tEstateDetail.getEstateName()+ ". You can still login on the App but you cannot create new passes. Please contact "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" in case of any queries.";
						String status1=SMSUtil.sendSMS("+91"+host.geteHostPhoneNo1(), message);
						System.out.println(status1);
						if(status1.equals("success")){								
							String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
								+ "<div>"+
										"<p>Hello <b>"+host.getEHostFirstName()+" "+host.getEHostLastName()+"</b>"
												+ ",</br> Your access for Pass creation has been revoked by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
												tEstateDetail.getEstateName()+ ".  You can still login on the App but you cannot create new passes.</br> Please contact "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" in case of any queries."
														+ "<p>DigiPass Team.</p>";
												
							
							boolean s=MailUtil.sendMail(host.geteHostEmail1(),emailMessage,"Digipass");							
							if(s){								
								tx.commit();
								status="SUCCESS";
								if(count!=estateHost.size()){
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
							status="ERROR";
							tx.rollback();
							throw new MessageSendFailed("Message sending failed");					
						}	
					}
				else if(hostUser.getAction().equals("DELETE"))
					for (TEstateHost host:estateHost) {
						count++;
						host.setUserStatus(3);
						host.setActiveStatus(0);
						host.setGrantAccess(0);
						TEstateAdmin estateAdmin2=host.getTEstateAdmin();
						TEstateDetail tEstateDetail=host.getTEstateDetail();
						
						String message="Hello "+host.getEHostFirstName()+" "+host.getEHostLastName()+" , Your digipass account has been deactivated by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
								tEstateDetail.getEstateName()+ ". You can't login on the App. Please contact "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" in case of any queries.";
						String status1=SMSUtil.sendSMS("+91"+host.geteHostPhoneNo1(), message);
						System.out.println(status1);
						if(status1.equals("success")){								
							String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
								+ "<div>"+
										"<p>Hello <b>"+host.getEHostFirstName()+" "+host.getEHostLastName()+"</b>"
												+ ",</br>  Your digipass account has been deactivated by "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" of "+
												tEstateDetail.getEstateName()+ ".  You can't login on the App.</br> Please contact "+estateAdmin2.getEAdminFirstName()+" "+estateAdmin2.getEAdminLastName()+" in case of any queries."
														+ "<p>DigiPass Team.</p>";
												
							
							boolean s=MailUtil.sendMail(host.geteHostEmail1(),emailMessage,"Digipass");							
							if(s){								
								tx.commit();
								status="SUCCESS";
								if(count!=estateHost.size()){
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
							status="ERROR";
							tx.rollback();
							throw new MessageSendFailed("Message sending failed");					
						}	
						
					}
				
				
			}catch(Exception e){
				e.printStackTrace();
				status="ERROR";
				tx.rollback();
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
	
	public String checkDuplicate(Model model, File file,HttpServletRequest request,String userName) throws Exception{
		String status=null;		
		try (CSVReader reader = new CSVReader(new FileReader(file), ',');){
			try {			
				SessionFactory sessionFactory = getSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tx = session.getTransaction();
				List<String[]> listData=reader.readAll();
				if(listData.size()==1){
					status="ERROR";
					model.addAttribute("msg", "Your Csv file should not be blank. Please download the CSV file and fillup your host data before uploading.");
					return status;
				}
				if(listData.size()>20){
					status="ERROR";
					model.addAttribute("msg", "Your CSV file must not have more than 20 records");
					return status;
				}
				try {
					tx.begin();
					TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
					List<TEstateHost> tEstateHostsList=estateAdmin.getTEstateHosts();
					System.out.println("file record size : "+listData.size());
					
					
						if(listData.size()>1){
							for (int i = 1; i < listData.size(); i++) {
								if(listData.get(i)[0]==null || (listData.get(i)[0].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "First Name should not be blank");
									return status;
								}else if(listData.get(i)[1]==null || (listData.get(i)[1].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Last Name should not be blank");
									return status;
								}else if(listData.get(i)[2]==null || (listData.get(i)[2].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Address Line1 should not be blank");
									return status;
								}else if(listData.get(i)[4]==null || (listData.get(i)[4].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "City should not be blank");
									return status;
								}else if(listData.get(i)[6]==null || (listData.get(i)[6].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "State should not be blank");
									return status;
								}else if(listData.get(i)[7]==null || (listData.get(i)[7].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Country should not be blank");
									return status;
								}else if(listData.get(i)[8]==null || (listData.get(i)[8].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Pincode should not be blank");
									return status;
								}else if(listData.get(i)[9]==null || (listData.get(i)[9].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Email address should not be blank");
									return status;
								}else if(listData.get(i)[11]==null || (listData.get(i)[11].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Mobile No should not be blank");
									return status;
								}else if(listData.get(i)[14]==null || (listData.get(i)[14].equals(""))){
									status="ERROR";
									model.addAttribute("msg", "Valid To should not be blank");
									return status;
								}else{
									for(TEstateHost host:tEstateHostsList){
										if(host.geteHostEmail1().equals(listData.get(i)[9])){
											status="ERROR";
											model.addAttribute("msg", "Already registered Email IDs ie '"+host.geteHostEmail1()+"' in the CSV file. Please correct and try again.");
											return status;
										}else{
											status="SUCCESS";
										}
									}	
								}
							}
						}else{
							status="ERROR";
							model.addAttribute("msg", "Csv file should not be blank");
							return status;
						}
					
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
			
			/*	String query = "select scripts_name from tbl_scripts where project_id="+viewScriptsForm.getProject()+" ";				
				connection = DBConnection.getConnection();
				List<String[]> listData=reader.readAll();
				if(listData.size()>2){
					String []script=new String[listData.size()-2];
					query=query+" and scripts_name in (";
					for (int i = 2; i < listData.size(); i++) {
						if(listData.get(i)[1]!=null || !(listData.get(i)[1].equals("")))
						script[i-2]="'"+listData.get(i)[1]+"'";
					}
					String scriptNames=Arrays.toString(script).substring(1, Arrays.toString(script).length()-1);
					query=query+scriptNames+")";
					System.out.println(query);
					pstmt = connection.prepareStatement(query);
					rs=pstmt.executeQuery();
					if(rs.next()){
						request.setAttribute("error", "Opps! One or more Scripts corresponding to the given project are exist already. Please check your csv file.");
						System.out.println("duplicate is there");
						return "duplicate";
					}else{
						TreeSet<String> unique = new TreeSet<String>();
						for(String str:script){
							if(!unique.add(str)){	
								request.setAttribute("error", "Opps! \""+str+"\" is duplicate in script file ");
								System.out.println("duplicate is there");
								return "duplicate";
								//System.out.println("Duplicate Entry is: "+str);
							}
						}
						return "noduplicate";
					}
				}else{
					request.setAttribute("error", "Opps! Please upload valid csv script file. File should not be blank.");
					status= "blank";
				}*/
			
		
		return status;
		}
	}
	public String uploadHostUser(File file,HttpServletRequest request,String userName,Model model)throws Exception
	{			
		String status = null;
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try (CSVReader reader = new CSVReader(new FileReader(file), ',');){
					tx.begin();			
					List<String[]> listData=reader.readAll();
					int count=0;
					if(listData.size()>1){
						HostUsers hostUser=null;
						for (int i = 1; i < listData.size(); i++) {					
							hostUser=new HostUsers();
							if(listData.get(i)[9]!=null || !(listData.get(i)[9].equals(""))){
								hostUser.setAddressLine1(listData.get(i)[2]);
								hostUser.setAddressLine2(listData.get(i)[3]);
								hostUser.setBuidingNo(listData.get(i)[13]);
								hostUser.setCity(listData.get(i)[4]);
								hostUser.setEmail1(listData.get(i)[9]);
								hostUser.setEmail2(listData.get(i)[10]);
								hostUser.setExpiredDate(listData.get(i)[15]);
								hostUser.setFirstName(listData.get(i)[0]);
								hostUser.setLastName(listData.get(i)[1]);
								hostUser.setPhoneNo1(listData.get(i)[11]);
								hostUser.setPhoneNo2(listData.get(i)[12]);
								hostUser.setPincode(listData.get(i)[8]);
								hostUser.setState(listData.get(i)[6]);
								hostUser.setUserType(listData.get(i)[16]);
								hostUser.setDistrict(listData.get(i)[5]);
								hostUser.setCountry(listData.get(i)[7]);
								hostUser.setDepartment(listData.get(i)[17]);
								
								
								TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
								long estateId=estateAdmin.getTEstateDetail().getEstateId();
								long adminId=estateAdmin.getEAdminId();
								TUsersLoginDetail usersLoginDetail=new TUsersLoginDetail();
								usersLoginDetail.setActiveStatus(1);
								//usersLoginDetail.setPassword("admin");
								String password=Utils.randInt()+"";
								usersLoginDetail.setPassword(password);
								
								TRoleDetail roleDetail=(TRoleDetail)session.load(TRoleDetail.class,new Long(3));
								usersLoginDetail.setTRoleDetail(roleDetail);
								usersLoginDetail.setUserName(hostUser.getEmail1());
								
								
								TUsersLoginDetail userDetail=(TUsersLoginDetail)session.get(TUsersLoginDetail.class, estateAdmin.getTUsersLoginDetail1().getUserId());
								usersLoginDetail.setTUsersLoginDetail(userDetail);
								
								
								
								session.save(usersLoginDetail);
								
								TEstateHost tEstateHost=new TEstateHost();
								tEstateHost.seteHostAddress1(hostUser.getAddressLine1());
								tEstateHost.seteHostAddress2(hostUser.getAddressLine2());
								tEstateHost.setEHostCity(hostUser.getCity());
								tEstateHost.setEHostDistrict(hostUser.getDistrict());
								tEstateHost.seteHostEmail1(hostUser.getEmail1());
								tEstateHost.seteHostEmail2(hostUser.getEmail2());
								tEstateHost.setEHostFirstName(hostUser.getFirstName());
								tEstateHost.setEHostLastName(hostUser.getLastName());
								tEstateHost.seteHostPhoneNo1(hostUser.getPhoneNo1());
								tEstateHost.seteHostPhoneNo2(hostUser.getPhoneNo2());
								tEstateHost.setEHostPinCode(hostUser.getPincode());
								tEstateHost.setEHostState(hostUser.getState());
								try {
									String expiryDate=hostUser.getExpiredDate().replaceAll("\\s+","");
									tEstateHost.setExpiredDate(Utils.getStringToTimeStamp(expiryDate));
								} catch (Exception e) {									
									throw new DateTimeFormatException("Date time format error");
								}
								
								tEstateHost.seteHostType(hostUser.getUserType());
								tEstateHost.seteHostDepartment(hostUser.getDepartment());
								tEstateHost.setBuildingNo(hostUser.getBuidingNo());
								tEstateHost.setGrantAccess(0);
								tEstateHost.setUserStatus(0);
								tEstateHost.setActiveStatus(0);
								
								tEstateHost.setTUsersLoginDetail1(usersLoginDetail);
								tEstateHost.setTUsersLoginDetail2(userDetail);
								
								TEstateDetail tEstateDetail=(TEstateDetail)session.load(TEstateDetail.class, estateId);
								tEstateHost.setTEstateDetail(tEstateDetail);
								
								TEstateAdmin estateAdmin2=(TEstateAdmin)session.load(TEstateAdmin.class, adminId);
								tEstateHost.setTEstateAdmin(estateAdmin2);				
								session.save(tEstateHost);			
								count++;
								hostUser=null;
							}
						}
						if((listData.size()-1)==count){
							status="SUCCESS";
							tx.commit();
						}else{
							tx.rollback();						
							status="ERROR";
						}
					}else{
						status="ERROR";
						tx.rollback();
						model.addAttribute("msg", "Csv file should not be blank");						
					}							
			}catch (DateTimeFormatException e) {
				status="DATETIME FORMAT ERROR";
				tx.rollback();
				throw e;
				
			}
			catch(Exception e){
				status="ERROR";
				tx.rollback();
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


	public HostUsers getHostDetailsBthostId(Long hostId) {
		HostUsers hostUser=new HostUsers();
		try {
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx1=session.getTransaction();
			try {
				tx1.begin();
				TEstateHost estateHost=(TEstateHost) session.createQuery("from TEstateHost where eHostId=:eHostId").setParameter("eHostId",hostId).uniqueResult();
				TEstateDetail tEstateDetail=estateHost.getTEstateDetail();
				System.out.println(tEstateDetail.getEstateTitle());
				hostUser.setHostUserId(estateHost.getEHostId());
				hostUser.setAddressLine1(estateHost.geteHostAddress1());
				hostUser.setAddressLine2(estateHost.geteHostAddress2());
				hostUser.setCity(estateHost.getEHostCity());
				hostUser.setDistrict(estateHost.getEHostDistrict());
				hostUser.setEmail1(estateHost.geteHostEmail1());
				hostUser.setEmail2(estateHost.geteHostEmail2());
				hostUser.setEstateAddress1(tEstateDetail.getEstateAddress1());
				hostUser.setEstateAddress2(tEstateDetail.getEstateAddress2());
				hostUser.setEstateCity(tEstateDetail.getEstateCity());
				hostUser.setEstateDistrict(tEstateDetail.getEstateDistrict());
				hostUser.setEstateName(tEstateDetail.getEstateName());
				hostUser.setEstatePincode(tEstateDetail.getEstatePinCode());
				hostUser.setEstateState(tEstateDetail.getEstateState());
				hostUser.setEstateEmail(tEstateDetail.getEstateEmail());
				hostUser.setEstateMobileNo(tEstateDetail.getEstateMobileNo());
				hostUser.setExpiredDate(Utils.getStringFromTimeStamp1(estateHost.getExpiredDate()));
				hostUser.setBuidingNo(estateHost.getBuildingNo());
				hostUser.setUserType(estateHost.geteHostType());
				hostUser.setDepartment(estateHost.geteHostDepartment());
				//hostUser.setValidFrom(Utils.getStringFromTimeStamp1(estateHost.getValidFrom()));
				hostUser.setFirstName(estateHost.getEHostFirstName());
				hostUser.setLastName(estateHost.getEHostLastName());
				hostUser.setPhoneNo1(estateHost.geteHostPhoneNo1());
				hostUser.setPhoneNo2(estateHost.geteHostPhoneNo2());
				hostUser.setPincode(estateHost.getEHostPinCode());
				hostUser.setState(estateHost.getEHostState());
				hostUser.setUserName(estateHost.getTUsersLoginDetail1().getUserName());
				hostUser.setStatus("SUCCESS");
			}catch(Exception e){
				hostUser.setStatus("ERROR");			
				tx1.rollback();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					throw e2;
				}
			}
		}catch(Exception e){			
			hostUser.setStatus("ERROR");
			throw e;
		}
	
		return hostUser;
	}


	public HostUsers updateHost(String userName, HostUsers hostUser) throws Exception {
		System.out.println(userName);
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				TEstateHost tEstateHost1=(TEstateHost)session.createQuery("from TEstateHost where eHostEmail1=:hostEmail1 and  eHostId!=:eHostId").setParameter("hostEmail1",hostUser.getEmail1()).setParameter("eHostId", hostUser.getHostUserId()).uniqueResult();
				if(tEstateHost1!=null){
					hostUser.setStatus("EXISTUSER");
					return hostUser;
				}				
				TEstateAdmin estateAdmin=(TEstateAdmin)session.createQuery("from TEstateAdmin where TUsersLoginDetail1.userName=:userName").setParameter("userName",userName).uniqueResult();
				long estateId=estateAdmin.getTEstateDetail().getEstateId();
				long adminId=estateAdmin.getEAdminId();
				//TUsersLoginDetail usersLoginDetail=new TUsersLoginDetail();
				//usersLoginDetail.setActiveStatus(1);
				//usersLoginDetail.setPassword("admin");
				
				//TRoleDetail roleDetail=(TRoleDetail)session.load(TRoleDetail.class,new Long(3));
				//usersLoginDetail.setTRoleDetail(roleDetail);
				
				//usersLoginDetail.setUserName(hostUser.getEmail1());
				
				
				//TUsersLoginDetail userDetail=(TUsersLoginDetail)session.load(TUsersLoginDetail.class, estateAdmin.getTUsersLoginDetail1().getUserId());
				//usersLoginDetail.setTUsersLoginDetail(userDetail);
				//session.save(usersLoginDetail);
				
				TEstateHost tEstateHost=(TEstateHost)session.load(TEstateHost.class, hostUser.getHostUserId());
				TUsersLoginDetail tUsersLoginDetail=(TUsersLoginDetail)session.createQuery("from TUsersLoginDetail where userName=:userName").setParameter("userName", tEstateHost.geteHostEmail1()).uniqueResult();
				tUsersLoginDetail.setUserName(hostUser.getEmail1());
				session.update(tUsersLoginDetail);
				
				tEstateHost.seteHostAddress1(hostUser.getAddressLine1());
				tEstateHost.seteHostAddress2(hostUser.getAddressLine2());
				tEstateHost.setEHostCity(hostUser.getCity());
				tEstateHost.setEHostDistrict(hostUser.getDistrict());
				tEstateHost.seteHostEmail1(hostUser.getEmail1());
				tEstateHost.seteHostEmail2(hostUser.getEmail2());
				tEstateHost.setEHostFirstName(hostUser.getFirstName());
				tEstateHost.setEHostLastName(hostUser.getLastName());
				tEstateHost.seteHostPhoneNo1(hostUser.getPhoneNo1());
				tEstateHost.seteHostPhoneNo2(hostUser.getPhoneNo2());
				tEstateHost.setEHostPinCode(hostUser.getPincode());
				tEstateHost.setEHostState(hostUser.getState());
				String expiryDate=hostUser.getExpiredDate()+hostUser.getExpiredTime().replaceAll("\\s+","");
				tEstateHost.setExpiredDate(Utils.getStringToTimeStamp(expiryDate));
				//tEstateHost.setValidFrom(Utils.getStringToTimeStamp(hostUser.getValidFrom()));
				tEstateHost.seteHostType(hostUser.getUserType());
				tEstateHost.seteHostDepartment(hostUser.getDepartment());
				tEstateHost.setBuildingNo(hostUser.getBuidingNo());
				//tEstateHost.setGrantAccess(0);
				//tEstateHost.setUserStatus(0);
				//tEstateHost.setActiveStatus(0);
				
				//tEstateHost.setTUsersLoginDetail1(usersLoginDetail);
				//tEstateHost.setTUsersLoginDetail2(userDetail);
				
				//TEstateDetail tEstateDetail=(TEstateDetail)session.load(TEstateDetail.class, estateId);
				//tEstateHost.setTEstateDetail(tEstateDetail);
				
				//TEstateAdmin estateAdmin2=(TEstateAdmin)session.load(TEstateAdmin.class, adminId);
				//tEstateHost.setTEstateAdmin(estateAdmin2);
				
				session.update(tEstateHost);				
				tx.commit();
				hostUser.setStatus("SUCCESS");				
			}catch(Exception e){
				hostUser.setStatus("ERROR");
				throw e;
			}finally{
				try {
					session.close();						
				} catch (Exception e2) {
					hostUser.setStatus("ERROR");
					throw e2;
				}
			}
		}catch(Exception e){
			hostUser.setStatus("ERROR");
			throw e;
		}
		
		return hostUser;
	}


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


	public String duplicateMobileCheck(String value) {
		String status=null;
		try {			
			SessionFactory sessionFactory = getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			try {
				tx.begin();
				List<TEstateHost> tEstateHostList=session.createQuery("from TEstateHost where eHostPhoneNo1=:eHostPhoneNo1").setParameter("eHostPhoneNo1",value).list();
				if(tEstateHostList.size()>=1){
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

}
