package com.adeptpros.digipass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adeptpros.digipass.beans.AdminUser;
import com.adeptpros.digipass.beans.ChangePassword;
import com.adeptpros.digipass.beans.Dashboard;
import com.adeptpros.digipass.beans.HostUsers;
import com.adeptpros.digipass.beans.UserLogin;
import com.adeptpros.digipass.bo.AdminUsersBo;
import com.adeptpros.digipass.bo.DashboardBo;

@Controller
public class Home {
	
	@Autowired
	private DashboardBo dashboardBo;	
	@Autowired
	
	private AdminUsersBo adminUsersBo;
	
	public DashboardBo getDashboardBo() {
		return dashboardBo;
	}


	public void setDashboardBo(DashboardBo dashboardBo) {
		this.dashboardBo = dashboardBo;
	}


	public AdminUsersBo getAdminUsersBo() {
		return adminUsersBo;
	}


	public void setAdminUsersBo(AdminUsersBo adminUsersBo) {
		this.adminUsersBo = adminUsersBo;
	}
	@RequestMapping(value="/")
	public String homePage(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))!=null){
		  return "redirect:"+"/dashboard";
		}else{
			UserLogin userLogin=new UserLogin();
			model.addAttribute("form","login");
			model.addAttribute("login", userLogin);
			return "index";
		}
		
	}
	@RequestMapping(value="/dashboard")
	public String dashboardPage(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}else{
			
			if((Long)session.getAttribute("roleid")==2){
				String userName=(String)session.getAttribute("userName");
				Dashboard dashboard=this.getDashboardBo().getDashboardInfo(userName);
				try {
					List<HostUsers> hostUserList=this.getDashboardBo().getAllUsersByAdminId(userName);
					model.addAttribute("hostUsersList", hostUserList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("dashboard", dashboard);
				return "dashboard";
			}else if((Long)session.getAttribute("roleid")==1){
				try {						
					String userName=(String)session.getAttribute("userName");
					List<AdminUser> adminUserList=this.getAdminUsersBo().getAllAdminUserBySuperAdminUser(userName);					
					model.addAttribute("adminUserList", adminUserList);
					model.addAttribute("adminUser", new AdminUser());
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "dashboard_superadmin";
			}else{
				return "index";
			}
		}
		
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup(Model model,HttpServletRequest request,HttpServletResponse response){
		model.addAttribute("adminUser", new AdminUser());
		return "signup";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}else{
			session.invalidate();
		}
		return "redirect:"+"/";
	}
	@RequestMapping(value="/change_password")
	public String profilePage(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		model.addAttribute("changePassword",new ChangePassword());
		return "changepass";
	}
	/*@RequestMapping(value="/user")
	public String userPage(Model model){
		return "users";
	}*/
	/*@RequestMapping(value="/history")
	public String historyPage(Model model){
		return "history";
	}*/
	/*@RequestMapping(value="/visitors")
	public String visitorsPage(Model model){
		return "visitors";
	}
	*/
}
