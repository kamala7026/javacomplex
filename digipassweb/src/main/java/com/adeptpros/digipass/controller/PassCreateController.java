package com.adeptpros.digipass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adeptpros.digipass.beans.PassBean;
import com.adeptpros.digipass.beans.PassHistory;
import com.adeptpros.digipass.bo.PassCreateBo;
import com.adeptpros.digipass.bo.PassHistoryBo;

@Controller
public class PassCreateController {
	@Autowired
	private PassHistoryBo passHistoryBo;
	
	@Autowired
	private PassCreateBo passCreateBo;

	
	public PassCreateBo getPassCreateBo() {
		return passCreateBo;
	}

	public void setPassCreateBo(PassCreateBo passCreateBo) {
		this.passCreateBo = passCreateBo;
	}

	public PassHistoryBo getPassHistoryBo() {
		return passHistoryBo;
	}

	public void setPassHistoryBo(PassHistoryBo passHistoryBo) {
		this.passHistoryBo = passHistoryBo;
	}
	
	@RequestMapping(value="/passinfo/{id}", method=RequestMethod.GET)
	public String passinfo(@PathVariable("id")Long id, Model model,HttpServletRequest request,HttpServletResponse response){
		PassHistory passDetails=new PassHistory();
		try {
			passDetails= this.getPassHistoryBo().getPassDetailsByPassId(id).get(0);
			System.out.println(passDetails.getVisitorAddress());
			model.addAttribute("pass", new PassBean());
			model.addAttribute("passDetails",passDetails);
		} catch (Exception e) {			
			e.printStackTrace();
			return "createpass";
		}
	
		return "createpass";
		
	}
	@RequestMapping(value="/passrequest", method=RequestMethod.POST)
	public String createPass(@ModelAttribute("pass")PassBean pass, Model model,HttpServletRequest request,HttpServletResponse response){
		PassHistory passDetails=new PassHistory();
		try {			
			
			String status=this.getPassCreateBo().createPass(pass);
			
			passDetails= this.getPassHistoryBo().getPassDetailsByPassId(pass.getPassId()).get(0);
			System.out.println(passDetails.getVisitorAddress());
			model.addAttribute("pass", new PassBean());
			model.addAttribute("passDetails",passDetails);
			model.addAttribute("status",status);
			if(status.equals("SUCCESS")){
				model.addAttribute("form","exist");
			}else{
				model.addAttribute("form","");
			}
			
			
		} catch (Exception e) {			
			e.printStackTrace();
			model.addAttribute("status","ERROR");
			model.addAttribute("form","");
			return "createpass";
		}
	
		return "createpass";
		
	}
}
