package com.shopping.global.controller;

import java.math.BigInteger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.global.bean.LoginBean;
import com.shopping.global.bo.LoginBO;
import com.shopping.global.bo.SignUpBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.LoginDTO;
import com.shopping.global.dto.SignUpDTO;
import com.shopping.global.exception.PasswordIncorrectException;
import com.shopping.global.exception.UserNotApprovedExeception;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.util.LogUserDetailsUtil;


@Controller
public class LoginController {
	
	final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private SignUpBO signUpBO;

	
	@Autowired
	private LoginBO loginBo;
	

	@Autowired
	private LogUserDetailsUtil logUserDetailsUtil;
	
	
	@RequestMapping(value=HtmConstants.USER_AUTH,method=RequestMethod.POST)
	public String userAunth(Model model,HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") LoginBean loginUser,@CookieValue("JSESSIONID") String cookie){
		logger.debug("userAunth :START");	
		String redirect="index";
			LoginDTO dto=new LoginDTO();
			if(loginUser.getUserName().equals("") && loginUser.getUserName()==null){
				model.addAttribute("status","userNameBlank");
			}else if(loginUser.getPassword().equals("") && loginUser.getPassword()==null){
				model.addAttribute("status","passwordBlank");
			}else{
				dto.setUserName(loginUser.getUserName());
				dto.setPassword(loginUser.getPassword());
				try {
					  ResponseDTO responseDTO=loginBo.userAuth(dto);
					  LoginDTO loginDTO=(LoginDTO) responseDTO.getResponseObject();
					if(responseDTO.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
						model.addAttribute("status","SUCCESS");		
						HttpSession session=request.getSession();
						loginDTO.setSessionId(cookie);
						String ipAddress = request.getHeader("X-FORWARDED-FOR");  
						   if (ipAddress == null) {  
							   ipAddress = request.getRemoteAddr();  
						   }
						loginDTO.setClientIp(ipAddress);
						loginDTO.setUserLogInTrackId(logUserDetailsUtil.LoguserData(loginDTO).toString());
						session.setAttribute("logInUser",loginDTO);
						response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
						response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
						response.setDateHeader("Expires", 0); // Proxies.
						request.getSession().setMaxInactiveInterval(600);
						if(loginDTO.getUserRole().equalsIgnoreCase(Constants.ADMIN)){
							redirect="dashboard";
						}else{
							redirect="dashboardBiller";
						}
					}else{
						model.addAttribute("status","INVALID");
					}
				}catch (PasswordIncorrectException e) {
					model.addAttribute("status","wrongPassword");
					model.addAttribute("message","UserName/Password is wrong");
				}
				catch (UserNotApprovedExeception e) {
					model.addAttribute("status","userNotApproved");
					model.addAttribute("message","User is not Approved.Contact Adminstrator.");
				}
				catch (Exception e) {
					e.printStackTrace();						
					model.addAttribute("status","INVALID");
				}finally{
					model.addAttribute("user",new LoginBean());
				}
			}
			logger.debug("userAunth :END");	
		return redirect;
		
	}
	@RequestMapping(method=RequestMethod.GET,value=HtmConstants.LOGOUT)
	  public String logout(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("logout :START");	
		
        LoginDTO loginDTO=(LoginDTO) request.getSession().getAttribute("logInUser");
        if(null !=loginDTO){
    		logUserDetailsUtil.updateInActiveUser(new BigInteger(loginDTO.getUserLogInTrackId()));
        }
        request.getSession().invalidate();
	    Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setValue(null);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        
        logger.debug("logout :END");	
	    return "redirect:/login.htm";
	  }
	@RequestMapping(value=HtmConstants.REGISTER,method=RequestMethod.POST)
	public String register(Model model,@ModelAttribute("signUp")SignUpDTO signUpData) {
		logger.debug("register :START");
		try {
			System.out.println("kamla");
			signUpBO.signUp(signUpData);
			model.addAttribute("user",new LoginBean());
			model.addAttribute("signUp",new SignUpDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.debug("register :END");
		return "index";
	}

	@RequestMapping(value=HtmConstants.NEW_REGISTER)
	public String redirectToNewRegisterPage(Model model) {
		logger.debug("redirectToNewRegisterPage :START");
		model.addAttribute("signUp",new SignUpDTO());
		logger.debug("redirectToNewRegisterPage :END");
		return "register";
	}

}
