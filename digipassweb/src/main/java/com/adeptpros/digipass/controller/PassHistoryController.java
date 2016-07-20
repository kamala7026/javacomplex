package com.adeptpros.digipass.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adeptpros.digipass.beans.PassHistory;
import com.adeptpros.digipass.bo.PassHistoryBo;
@Controller
public class PassHistoryController {

	@Autowired
	private PassHistoryBo passHistoryBo;

	public PassHistoryBo getPassHistoryBo() {
		return passHistoryBo;
	}

	public void setPassHistoryBo(PassHistoryBo passHistoryBo) {
		this.passHistoryBo = passHistoryBo;
	}
	@RequestMapping(value="/history",method=RequestMethod.GET)
	public String getPassHistory(Model model, HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		List<PassHistory> passList=null;		
		String userName=(String)session.getAttribute("userName");
		try {
			model.addAttribute("passHistory",new PassHistory());
			passList=this.getPassHistoryBo().getPassHistory(userName);
			model.addAttribute("passList",passList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "history";	
	}
	@RequestMapping(value="/history",method=RequestMethod.POST)
	public String getPassHistoryByFilter(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("passHistory")PassHistory passHistory){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		List<PassHistory> passList=null;		
		String userName=(String)session.getAttribute("userName");
		try {
			passList=this.getPassHistoryBo().getPassHistoryByFilter(userName,passHistory);
			model.addAttribute("passList",passList);
			model.addAttribute("passHistory",new PassHistory());
			model.addAttribute("filter","filter");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "history";
		
	}
	
	@RequestMapping(value="/history/{id}",method=RequestMethod.GET)
	public String getPassDetailsByPassId(Model model, HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Long id){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		List<PassHistory> passList=null;
		String userName=(String)session.getAttribute("userName");
		try {
			passList=this.getPassHistoryBo().getPassDetailsByPassId(id);
			model.addAttribute("passHistory", new PassHistory());
			model.addAttribute("passList",passList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "history";
		
	}
	@RequestMapping(value="/visitors",method=RequestMethod.GET)
	public String getVisitors(Model model, HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		List<PassHistory> passList=null;
		String userName=(String)session.getAttribute("userName");
		try {
			passList=this.getPassHistoryBo().getPassHistory(userName);
			model.addAttribute("passList",passList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "visitors";
		
	}
}
