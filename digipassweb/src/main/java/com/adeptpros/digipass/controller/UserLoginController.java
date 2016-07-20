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
import com.adeptpros.digipass.beans.ChangePassword;
import com.adeptpros.digipass.beans.UserLogin;
import com.adeptpros.digipass.bo.AdminUsersBo;
import com.adeptpros.digipass.bo.UserLoginBo;
import com.adeptpros.digipass.exception.InvalidPassword;
import com.adeptpros.digipass.exception.InvalidUser;

@Controller
public class UserLoginController {
	@Autowired
	private UserLoginBo userLoginBo;
	


	public UserLoginBo getUserLoginBo() {
		return userLoginBo;
	}
	

	public void setUserLoginBo(UserLoginBo userLoginBo) {
		this.userLoginBo = userLoginBo;
	}
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public String changePassword(HttpServletRequest request,HttpServletResponse response,Model model,@ModelAttribute("changePassword")ChangePassword changePassword){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		try {
			changePassword.setUserId((Long)session.getAttribute("userId"));
			String status=this.getUserLoginBo().changePassword(changePassword);
			if(status.equals("SUCCESS")){
				model.addAttribute("success","SUCCESS");
				model.addAttribute("msg","Password updated successfully.");
			}else{
				model.addAttribute("msg","Internal server problem Please try again later.");
				model.addAttribute("error","ERROR");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg","Internal server problem Please try again later.");
			model.addAttribute("error","ERROR");
		}
		return "dashboard";
	}

	@RequestMapping(value="/userAunth",method=RequestMethod.POST)
	public String userAuth(HttpServletRequest request, HttpServletResponse response, Model model,@ModelAttribute("login")UserLogin userLogin){
		String forward="";
		UserLogin userLogin2=new UserLogin();
		try {
			userLogin2=this.userLoginBo.userLogin(userLogin);
			System.out.println(userLogin2.getLoginStatus());
			if(userLogin2.getLoginStatus().equals("VALIDED")){
				//model.addAttribute("userLogin", userLogin2);
				HttpSession session=request.getSession();
				session.setAttribute("userId", userLogin2.getUserId());				
				session.setAttribute("name", userLogin2.getName());
				session.setAttribute("roleid", userLogin2.getRoleId());
				session.setAttribute("company",userLogin2.getCompanyName());
				session.setAttribute("userName", userLogin2.getUserName());
				if(userLogin2.getRoleId()==2)
					return "redirect:"+"/dashboard";
				if(userLogin2.getRoleId()==1){					
					return "redirect:"+"/dashboard";
				}
			}else if(userLogin2.getLoginStatus().equals("NOTALOW")){
				model.addAttribute("status","INVALID");
				forward="index";
			}else if(userLogin2.getLoginStatus().equals("NOTACTIVE")){
				model.addAttribute("status","INVALID");
				forward="index";
			}
		}catch (InvalidUser e) {
			model.addAttribute("status","INVALID");
			forward="index";
			//e.printStackTrace();
		}
		catch (InvalidPassword e) {
			model.addAttribute("status","INVALID");
			forward="index";
			//e.printStackTrace();
		}catch (Exception e) {
			model.addAttribute("status","Internal server problem! Please try again.");
			forward="index";
			e.printStackTrace();
		}
		return forward;
	}
	@RequestMapping(value="/forgetpassword",method=RequestMethod.POST)
	public String forgetPassword(HttpServletRequest request, HttpServletResponse response, Model model,@ModelAttribute("login")UserLogin userLogin){
		String status="";
		model.addAttribute("form","forget");
		model.addAttribute("userLogin",new UserLogin());
		try {
			status=this.userLoginBo.forgetPassword(userLogin);
			if(status.equals("SUCCESS")){
				model.addAttribute("success", "SUCCESS");
				model.addAttribute("msg","Password has been reset successfully. Please check your registered email for new password.");
			}
		}catch (InvalidUser e) {
			model.addAttribute("error","ERROR");
			model.addAttribute("msg","You have entered wrong email id or it's not a registered email id. Please enter a valid email id.");
		}
		catch (Exception e) {
			model.addAttribute("error","ERROR");
			model.addAttribute("msg","Internal server problem! Please try again.");
			e.printStackTrace();
		}
		return "index";
	}
}
