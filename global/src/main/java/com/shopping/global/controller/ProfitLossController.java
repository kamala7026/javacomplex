package com.shopping.global.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dao.PrintUtilityDAO;
import com.shopping.global.dto.PrintCustomerDetails;
import com.shopping.global.model.TdProfitLoss;

@Controller
public class ProfitLossController {

	final static Logger logger = LoggerFactory.getLogger(ProfitLossController.class);
	
	@Autowired
	private PrintUtilityDAO printUtilityDAO;
	
	@RequestMapping(value=HtmConstants.VIEW_PROFIT_LOSS,method={RequestMethod.GET,RequestMethod.POST})
	public String viewProfitLoss(Model model) {
		logger.debug("viewProfitLoss :START");
		
		logger.debug("viewProfitLoss :END");
		
		return "viewProfitLoss";
	}
	@RequestMapping(value=HtmConstants.SHOW_PROFIT_LOSS,method={RequestMethod.POST})
	public String showProfitLoss(Model model,@ModelAttribute("showProfitLoss")PrintCustomerDetails printCustomerDetails) {
		logger.debug("showProfitLoss :START");
		@SuppressWarnings("rawtypes")
		List<TdProfitLoss> tdProfitLoss;
		try {
			tdProfitLoss = printUtilityDAO.fetchProfitBetweenDates(printCustomerDetails.getStartDate(),printCustomerDetails.getEndDate());
			model.addAttribute("profitLossDetails",tdProfitLoss);
			model.addAttribute("searchHappen","true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("profitLossDetails",null);
			model.addAttribute("searchHappen","true");
		}
		
		
		logger.debug("showProfitLoss :END");
		
		return "profitLossDetails";
	}
}
