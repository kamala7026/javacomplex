package com.shopping.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.LoginDTO;
import com.shopping.global.util.LogUserDetailsUtil;

public class AuthenticationInterceptor implements HandlerInterceptor  {
	final static Logger logger = LoggerFactory.getLogger(LogUserDetailsUtil.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String uri=request.getServletPath();
		String contextPath=request.getContextPath();
		if(! ArrayUtils.contains(HtmConstants.WHITE_LISTED_URLS, uri ) && ! uri.contains("/resources"))
		{
			LoginDTO logInData = (LoginDTO) request.getSession().getAttribute("logInUser");
			if(logInData == null)
			{
					response.sendRedirect(contextPath+HtmConstants.LOGOUT);
				return false;
			}
			else if(StringUtils.isBlank(logInData.getSessionId())){
				response.sendRedirect(contextPath+HtmConstants.LOGOUT);
				return false;
			}
		}

		return true;
	}

}
