package com.adeptpros.digipass.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adeptpros.digipass.beans.AdminUser;
import com.adeptpros.digipass.bo.AdminUsersBo;

@Controller
public class AdminUsersController {

	@Autowired
	private AdminUsersBo adminUsersBo;

	public AdminUsersBo getAdminUsersBo() {
		return adminUsersBo;
	}

	public void setAdminUsersBo(AdminUsersBo adminUsersBo) {
		this.adminUsersBo = adminUsersBo;
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String registerAdminUser(Model model,HttpServletRequest request, HttpServletResponse response,@ModelAttribute("adminUser")AdminUser adminUser){
		String redirect="/";
		try {
			String s=this.getAdminUsersBo().duplicateEmailCheck(adminUser.getEmailId());
			if(s.equals("DUPLICATE")){
				model.addAttribute("status","ERROR");
				model.addAttribute("adminUser", adminUser);
				model.addAttribute("msg", "The given email id is already exist.");
				redirect="signup";
			}else{
				String status=this.getAdminUsersBo().registerAdminUser(adminUser);
				if(status.equals("SUCCESS")){
					model.addAttribute("status","SUCCESS");
					model.addAttribute("adminUser", new AdminUser());
					model.addAttribute("msg", "Thank you for registering on DigiPass. You will shortly receive an Email after approval is completed.");
					redirect="signupsuccess";
				}else{
					model.addAttribute("status", "ERROR");
					model.addAttribute("adminUser", adminUser);
					model.addAttribute("msg", "Internal server problems!! Please try again later.");
					redirect="signup";
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("status", "ERROR");
			model.addAttribute("msg","Internal server problems!! Please try again later.");
			redirect="signup";
		}
		return redirect;
	}
	
	@RequestMapping(value="/organisationUsers",method=RequestMethod.GET)
	public String getAllAdminUserBySuperAdminUser(Model model,HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession session=request.getSession();
			if((session.getAttribute("userId"))==null){
				return "redirect:"+"/";
			}
			String userName=(String)session.getAttribute("userName");
			List<AdminUser> adminUserList=this.getAdminUsersBo().getAllAdminUserBySuperAdminUser(userName);
			model.addAttribute("adminUser", adminUserList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "dashboard_superadmin";
	}
	@RequestMapping(value="/organisationUsers",method=RequestMethod.POST)
	public String setAccess(Model model,HttpServletRequest request, HttpServletResponse response,@ModelAttribute("adminUser")AdminUser adminUser){
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		try {			
			if((session.getAttribute("userId"))==null){
				return "redirect:"+"/";
			}			
			String status=this.getAdminUsersBo().setAccess(adminUser);
			if(status.equals("SUCCESS")){
				
				model.addAttribute("status", "SUCCESS");
				if(adminUser.getAction().equals("ACTIVE"))
					model.addAttribute("msg", "Activated Successfully");
				if(adminUser.getAction().equals("DEACTIVE"))
					model.addAttribute("msg", "Deactivated Successfully");
			}else{
				model.addAttribute("status", "ERROR");
				model.addAttribute("msg", "Something went wrong. Please check Admin details and try again.");
			}			
		} catch (Exception e) {
			model.addAttribute("status", "ERROR");
			model.addAttribute("msg", "Something went wrong. Please check Admin details and try again.");
			e.printStackTrace();
		}
		List<AdminUser> adminUserList=this.getAdminUsersBo().getAllAdminUserBySuperAdminUser(userName);
		model.addAttribute("adminUserList", adminUserList);
		model.addAttribute("adminUser", new AdminUser());
		return "dashboard_superadmin";
	}
	
	@RequestMapping(value="/admin_profile",method=RequestMethod.GET)
	public String getAdminProfile(Model model,HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession session=request.getSession();
			if((session.getAttribute("userId"))==null){
				return "redirect:"+"/";
			}
			String userName=(String)session.getAttribute("userName");
			AdminUser adminUser=this.getAdminUsersBo().getAdminUser(userName);
			model.addAttribute("adminUser", adminUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "adminProfile";
	}
	@RequestMapping(value="/admin_profile",method=RequestMethod.POST)
	public String updateAdminProfile(Model model,HttpServletRequest request, HttpServletResponse response,@ModelAttribute("adminUser")AdminUser adminUser){
		String redirect="/";
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
		AdminUser adminUser1=this.getAdminUsersBo().getAdminUser(userName);
		try {
			if(!adminUser1.getEmailId().equals(adminUser.getEmailId())){
				String s=this.getAdminUsersBo().duplicateEmailCheck(adminUser.getEmailId());
				if(s.equals("DUPLICATE")){
					model.addAttribute("status","ERROR");
					model.addAttribute("adminUser", adminUser);
					model.addAttribute("msg", "The given email id is already exist.");
					redirect="adminProfile";
				}else{
					String status=this.getAdminUsersBo().updateAdminUser(adminUser);
					if(status.equals("SUCCESS")){
						model.addAttribute("status","SUCCESS");
						adminUser1=null;						
						model.addAttribute("msg", "Updated successfully.");						
						redirect="adminProfile";
					}else{
						model.addAttribute("status", "ERROR");
						model.addAttribute("adminUser", adminUser);
						model.addAttribute("msg", "Internal server problems!! Please try again later.");
						redirect="adminProfile";
					}
				}	
			}else{
				
				String status=this.getAdminUsersBo().updateAdminUser(adminUser);
				if(status.equals("SUCCESS")){
					model.addAttribute("status","SUCCESS");
					adminUser1=null;
					adminUser1=this.getAdminUsersBo().getAdminUser(userName);
					model.addAttribute("adminUser", adminUser1);
					model.addAttribute("msg", "Updated successfully.");
					redirect="adminProfile";
				}else{
					model.addAttribute("status", "ERROR");
					model.addAttribute("adminUser", adminUser);
					model.addAttribute("msg", "Internal server problems!! Please try again later.");
					redirect="adminProfile";
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("status", "ERROR");
			model.addAttribute("msg","Internal server problems!! Please try again later.");
			redirect="adminProfile";
		}
		
		adminUser1=this.getAdminUsersBo().getAdminUser(userName);
		session.setAttribute("company",adminUser1.getCompanyName());
		session.setAttribute("name", adminUser1.getFirstName()+" "+adminUser1.getLastName());
		model.addAttribute("adminUser", adminUser1);
		return redirect;
	}
	
	
}
