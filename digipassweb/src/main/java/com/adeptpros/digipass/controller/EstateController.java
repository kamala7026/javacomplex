package com.adeptpros.digipass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adeptpros.digipass.beans.EstateDetails;
import com.adeptpros.digipass.bo.EstateBo;

@Controller
public class EstateController {
	@Autowired
	private EstateBo estateBo;
	

	public EstateBo getEstateBo() {
		return estateBo;
	}


	public void setEstateBo(EstateBo estateBo) {
		this.estateBo = estateBo;
	}


	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getEstateDetails(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
		EstateDetails estate=new EstateDetails();
		try {
			estate=this.estateBo.getEstateDetails(userName);
			System.out.println(estate.getEstateName());
		} catch (Exception e) {
			e.printStackTrace();			
		}		
		model.addAttribute("estate",estate);
		return "profile";
	}
}
