package com.shopping.global.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.global.bean.LoginBean;
import com.shopping.global.bo.SignUpBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dao.LoginDAO;
import com.shopping.global.dto.LoginDTO;
import com.shopping.global.dto.PasswordChangeDTO;
import com.shopping.global.dto.SignUpDTO;
import com.shopping.global.util.EmailUtility;
import com.shopping.global.util.EncryptDecrypt;

@Controller
@Configuration
@PropertySource(value="classpath:application.properties")
public class HomeController {

	final static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SignUpBO SignUpBO;

	@Autowired
	private EmailUtility emailUtility;

	@Autowired
	private LoginDAO logInDAO;

	@Autowired
	private EncryptDecrypt encryptDecrypt;

	@Value("${fromId}")
    String fromId;

	@Value("${fromUserName}")
    String fromUserName;

	@Value("${password}")
    String password;

	@RequestMapping(value=HtmConstants.LOGIN)
	public String login(Model model) {
		logger.debug("login :START");
		model.addAttribute("user",new LoginBean());
		logger.debug("login :START");
		return "index";
	}
	@RequestMapping(value="/")
	public String defaultMapping(Model model) {
		logger.debug("login :START");
		model.addAttribute("user",new LoginBean());
		logger.debug("login :START");
		return "index";
	}
	@RequestMapping(value=HtmConstants.RECOVER_PSWRD)
	public String recoverPassword(Model model) {
		logger.debug("recoverPassword :START");
		model.addAttribute("email",new String());
		logger.debug("recoverPassword :END");
		return "recoverpw";
	}
	@RequestMapping(value=HtmConstants.RESET_PSWRD)
	public String resetPassword(Model model) {
		logger.debug("resetPassword :START");
		logger.debug("resetPassword :END");
		return "resetPassword";
	}
	@RequestMapping(value=HtmConstants.RESET_ING_PSWRD)
	public String resetIngPassword(Model model) {
		logger.debug("resetIngPassword :START");


		model.addAttribute("user",new LoginBean());
		logger.debug("resetIngPassword :END");
		return "index";
	}
	@RequestMapping(value=HtmConstants.FORGOT_PSWD)
	public String resetPassword(Model model,@ModelAttribute("email")String email,@ModelAttribute("userName")String userName,HttpServletRequest request) {
		logger.debug("recoverPassword :START");
		Boolean authorise=logInDAO.forgotPswd(email, userName);
		String contextPath=request.getContextPath();
		String []fullPath=request.getRequestURL().toString().split(contextPath);
		if(authorise){
			String randomString=this.generateRandomString(email, userName,contextPath,fullPath[0]);
			SecureRandom random = new SecureRandom();

			String body= "Click on the link for password reset:- "+randomString;
			try{
				emailUtility.sendMails(email, fromId, fromUserName,password, body);
				//String randomStringforDB= new BigInteger(130, random).toString(16);

			}catch(Exception e){
				e.printStackTrace();
			}

		}

		logger.debug("recoverPassword :END");
		return "recoverpw";
	}

	@RequestMapping(value=HtmConstants.RESET_PASWRD)
	public String resetPassword(Model model,HttpServletRequest request) {
		logger.debug("resetPassword :START");
		String requestValue=encryptDecrypt.decrypt(request.getParameter("forgotPassword"));
		if(StringUtils.isNotBlank(requestValue)){
			//this.validateRequestValue(requestValue);
			String [] inputs=requestValue.split("###");

			PasswordChangeDTO passwordChangeDTO=new PasswordChangeDTO();
			passwordChangeDTO.setUserName(inputs[1]);
			model.addAttribute("passwordChange",passwordChangeDTO);
			return "resetNewPassword";
		}

		logger.debug("resetPassword :END");
		return "index";
	}
	@RequestMapping(value=HtmConstants.PASSWORD_CHANGE)
	public String changePassword(Model model,@ModelAttribute PasswordChangeDTO passwordChange) {
		logger.debug("changePassword :START");
		if(StringUtils.equals(passwordChange.getNewPassword(),passwordChange.getConfirmPassword())){
			try {
				int status=logInDAO.changePassword(passwordChange.getUserName(),passwordChange.getNewPassword());
				if(status>0){
					model.addAttribute("user",new LoginBean());
					return "index";
				}
				else{
					model.addAttribute("passwordChange",passwordChange);
					model.addAttribute("status",Constants.ERROR);
					model.addAttribute("message","Error happened ...");
					model.addAttribute("searchHappen","true");
					return "resetNewPassword";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				model.addAttribute("passwordChange",passwordChange);
				model.addAttribute("status",Constants.ERROR);
				model.addAttribute("message","Error happened ...");
				model.addAttribute("searchHappen","true");
				return "resetNewPassword";
			}

		}
		logger.debug("changePassword :END");

		model.addAttribute("passwordChange",passwordChange);
		model.addAttribute("status",Constants.ERROR);
		model.addAttribute("message","Password and confirm password is not same... Try Again...");
		model.addAttribute("searchHappen","true");
		return "resetNewPassword";
	}

	@RequestMapping(value=HtmConstants.DASHBOARD)
	public String dashboard(Model model,HttpServletRequest request) {
		logger.debug("dashboard :START");
		model.addAttribute("user",new LoginBean());
		logger.debug("dashboard :END");
		String redirect=null;
		LoginDTO loginDTO=(LoginDTO)request.getSession(true).getAttribute("logInUser");
		if(loginDTO.getUserRole().equalsIgnoreCase(Constants.ADMIN)){
			redirect="dashboard";
		}else{
			redirect="dashboardBiller";
		}
		return redirect;
	}

	@RequestMapping(value=HtmConstants.NEW_REGISTER)
	public String redirectToNewRegisterPage(Model model) {
		logger.debug("redirectToNewRegisterPage :START");
		model.addAttribute("signUp",new SignUpDTO());
		logger.debug("redirectToNewRegisterPage :END");
		return "register";
	}

	@RequestMapping(value=HtmConstants.REGISTER)
	public String register(Model model,@ModelAttribute("signUp")SignUpDTO signUpData) {
		logger.debug("register :START");
		try {
			SignUpBO.signUp(signUpData);
			model.addAttribute("user",new LoginBean());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("register :END");
		return "index";
	}
	private String generateRandomString(String email,String userName,String contextPath,String relativePath){
		String encryptedString=encryptDecrypt.encrypt(StringEscapeUtils.escapeHtml4(email)+"###"+userName);
		return relativePath+contextPath+HtmConstants.RESET_PASWRD+"?&forgotPassword="+encryptedString;
	}
}
