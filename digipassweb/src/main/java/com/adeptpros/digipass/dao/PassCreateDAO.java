package com.adeptpros.digipass.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adeptpros.digipass.beans.PassBean;
import com.adeptpros.digipass.entities.TEstateAdmin;
import com.adeptpros.digipass.entities.TEstateDetail;
import com.adeptpros.digipass.entities.TEstateHost;
import com.adeptpros.digipass.entities.TPassDetail;
import com.adeptpros.digipass.entities.TUsersLoginDetail;
import com.adeptpros.digipass.exception.MessageSendFailed;
import com.adeptpros.digipass.exception.PassImageCreationError;
import com.adeptpros.digipass.utility.MailUtil;
import com.adeptpros.digipass.utility.SMSUtil;
import com.adeptpros.digipass.utility.Utils;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


@Component
public class PassCreateDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public String createPass(PassBean pass)throws Exception {
		String status=null;
		try {
			SessionFactory sessionFactory =this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx1=session.getTransaction();
			try {
				tx1.begin();
				TPassDetail passDetail=(TPassDetail) session.load(TPassDetail.class, pass.getPassId());
				passDetail.setVisitorAddress(pass.getVisitorAddress());
				passDetail.setVisitorCompanyName(pass.getCompanyName());
				passDetail.setVisitorVanue(pass.getVisitorVanue());
				passDetail.setVisitorPurpose(pass.getVisitorPurpose());
				
				//TEstateHost hostDetail=(TEstateHost) session.createQuery("from TEstateHost where TUsersLoginDetail1.userName=:userName").setParameter("userName",pass.getUserName()).uniqueResult();
				//passDetail.setTEstateHost(hostDetail);
				
				//TEstateDetail estateDetail=hostDetail.getTEstateDetail();
				//passDetail.setTEstateDetail(estateDetail);
				
				//TUsersLoginDetail  usersLoginDetail=hostDetail.getTUsersLoginDetail1();
				//passDetail.setTUsersLoginDetail(usersLoginDetail);
				
				//TEstateAdmin estateAdmin=hostDetail.getTEstateAdmin();
				//passDetail.setTEstateAdmin(estateAdmin);
				
				if(pass.getVisitorEmailId()!=null || !pass.getVisitorEmailId().equals(""))
				passDetail.setVisitorEmailId(pass.getVisitorEmailId());
				if(pass.getVisitorEndTime()==null || pass.getVisitorEndTime().equals("")){
					status="EndTime is Null";
				}else{
					passDetail.setVisitorEndTime(Utils.getStringToTimeStamp1(pass.getVisitorEndTime()));
				}
				if(pass.getVisitorStartTime()==null || pass.getVisitorStartTime().equals("")){
					status="StartTime is Null";
				}else{
					passDetail.setVisitorStartTime(Utils.getStringToTimeStamp1(pass.getVisitorStartTime()));
				}
				if(pass.getVisitorInstruction()!=null || !pass.getVisitorInstruction().equals(""))
				passDetail.setVisitorInstruction(pass.getVisitorInstruction());
				if(pass.getVisitorMobileNo()!=null || !pass.getVisitorMobileNo().equals(""))
				passDetail.setVisitorMobNo(pass.getVisitorMobileNo());
				if(pass.getVisitorVechilesDetails()!=null || !pass.getVisitorVechilesDetails().equals(""))
				passDetail.setVisitorVechilesDetails(pass.getVisitorVechilesDetails());
				if(pass.getVisitorFirstName()!=null || !pass.getVisitorFirstName().equals("")){
					passDetail.setVisitorFirstName(pass.getVisitorFirstName());
				}else{
					status="First Name is Null";
				}
				if(pass.getVisitorLastName()!=null || !pass.getVisitorLastName().equals("")){
					passDetail.setVisitorLastName(pass.getVisitorLastName());
				}else{
					status="First Name is Null";
				}
				if(pass.getVisitorEquipmentDetails()!=null || !pass.getVisitorEquipmentDetails().equals(""))
				passDetail.setVisitorEquipmentDetails(pass.getVisitorEquipmentDetails());
				
				//session.save(passDetail);
				passDetail.setPassApprovalStatus(1);
				session.update(passDetail);
				
				String link=createPassLink(passDetail.getPassId());
				/*if(!link.equals("error")){
					passDetail.setVisitorPassLink(link);
					session.update(passDetail);
				}else{
					throw new PassImageCreationError("QR image creation error");
				}*/
				
				
				
				/*String message="Hello "+passDetail.getVisitorFirstName()+" "+passDetail.getVisitorLastName()+" ,Pass for your meeting with "+passDetail.getTEstateAdmin().getEAdminFirstName()+" "+passDetail.getTEstateAdmin().getEAdminLastName()+", "+
						passDetail.getTEstateDetail().getEstateName()+ " has been created successfully. Click on the bellow URL to get your pass details. "+link;
				String status1=SMSUtil.sendSMS("+91"+pass.getVisitorMobileNo(), message);
				System.out.println(status1);
				if(status1.equals("success")){
					
					String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
							+ "<div><h2 style='color:blue'>Welcome to Digipass</h2>"+
									"<p>Your Digipass URL has been created by</p>"+
									"<p>"+passDetail.getTEstateAdmin().getEAdminFirstName()+" "+passDetail.getTEstateAdmin().getEAdminLastName()+"<br/>"+
									passDetail.getTEstateDetail().getEstateName()+"<br/>"+
									passDetail.getTEstateDetail().getEstateAddress1()+","+passDetail.getTEstateDetail().getEstateAddress2()+"<br/>"+
									passDetail.getTEstateDetail().getEstateCity()+"<br/>"+
									passDetail.getTEstateDetail().getEstateState()+"<br/>"+
									passDetail.getTEstateDetail().getEstatePinCode()+"<br/><br/><br/>"+									
									"<b>Entry Time :  </b>"+pass.getVisitorStartTime()+									
									"<br/><br/><b>Pass URL:  </b>"+link;	
					
					
					String emailMessage="<div style='margin-left:20px;'><img src='http://182.75.216.94:8080/digipassweb/resources/theme/img/logo.png'/></div>"
							+ "<div><h2 style='color:blue'>Welcome to Digipass</h2>"+
									"<p>Hello <b>"+passDetail.getVisitorFirstName()+" "+passDetail.getVisitorLastName()+"</b>,"
											+ ", Pass for your meeting with "+passDetail.getTEstateAdmin().getEAdminFirstName()+" "+passDetail.getTEstateAdmin().getEAdminLastName()+", "+
											passDetail.getTEstateDetail().getEstateName()+ " has been created successfully.</p>"
											+ "<p>Your pass details: </p></br>"+
									
									"<p><b>Valid from :  </b>"+passDetail.getVisitorStartTime()+"</p>"+
									"<p><b>Expire Time :  </b>"+passDetail.getVisitorEndTime()+"</p>"+
									"<p><b>Vanue :  </b>"+passDetail.getTEstateDetail().getEstateName()+"<br/>"+
									passDetail.getTEstateDetail().getEstateAddress1()+","+passDetail.getTEstateDetail().getEstateAddress2()+","+
									passDetail.getTEstateDetail().getEstateCity()+","+
									passDetail.getTEstateDetail().getEstateState()+","+
									passDetail.getTEstateDetail().getEstatePinCode()+"<br/><p>"+
									
									"<p><b>Pass link: </b>"+link+"</p></br></br></br></br>"
											+ "<p><b>DigiPass Team</b></p>";
					
					boolean s=MailUtil.sendMail(pass.getVisitorEmailId(),emailMessage,"Digipass");
					if(s){*/
						tx1.commit();
						status="SUCCESS";
						//passDetails.setVisitorPassLink(link);
						/*System.out.println(status);
					}else{
						System.out.println(status);
						throw new MessageSendFailed("Email sending failed");
					}*/
					
				/*}else{
					System.out.println(status);
					throw new MessageSendFailed("Message sending failed");					
				}*/			
			}catch(Exception e){
					e.printStackTrace();
					status="ERROR";
					tx1.rollback();
			}finally{
					try {
						session.close();
					} catch (Exception e2) {
						status="ERROR";
						tx1.rollback();
						e2.printStackTrace();
					}
				}
		
		} catch (Exception e) {
			status="ERROR";
			throw e;
		}
		return status;
	}
	
	private String createPassLink(long l) {
		String status="";
		//MessageContext mc = MessageContext.getCurrentMessageContext();
		File f1 = new File("E://qrimage/"+l+".jpg");  
		String p=f1.getPath();	
		String p1=p.replace("\\WEB-INF\\", "\\");
		File f=new File(p1);
		ByteArrayOutputStream out = QRCode.from(Long.toString(l)).to(ImageType.PNG).stream();		
		try {
			FileOutputStream fout = new FileOutputStream(f);				
			fout.write(out.toByteArray());				
			fout.flush();
			fout.close();
			System.out.println("suucessfully pass qr image created");
			status="http://182.75.216.94:8080/digipass/pass/passlink?id="+l;
		} catch (FileNotFoundException e) {
			status="error";
			e.printStackTrace();// Do Logging
		} catch (Exception e) {
			status="error";
			e.printStackTrace();
		}
		return status;
	}

}
