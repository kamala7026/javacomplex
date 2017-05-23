package com.shopping.global.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.global.bean.NewCashTransactionDetailsBean;
import com.shopping.global.bo.CashTransactionServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.services.ResponseDTO;

@Controller
public class CashController {

	@Autowired
	private CashTransactionServiceBO cashTransactionServiceBO;
	
	final static Logger logger = LoggerFactory.getLogger(CashController.class);
	
	@RequestMapping(value=HtmConstants.ADD_CASH_PAGE)
	public String redirectToCashAddPage(Model model) {
		logger.debug("redirectToCashAddPage :START");
		ResponseDTO response=new ResponseDTO();
		try {
			response=cashTransactionServiceBO.validateAndSearchCustomerDetails();
			NewCashTransactionDetailsBean newBillDetailsBean=new NewCashTransactionDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			model.addAttribute("cashPaidDetails",new NewCashTransactionDetailsBean());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("redirectToCashAddPage :END");
		return "addCashTransaction";
	}
	private NewCashTransactionDetailsBean prepareNewBillBean(ResponseDTO response){
		logger.debug("prepareNewBillBean :START");
		NewCashTransactionDetailsBean newBillDetailsBean= (NewCashTransactionDetailsBean) response.getResponseObject();
		logger.debug("prepareNewBillBean :END");
		return newBillDetailsBean;
	}
	
	@RequestMapping(value=HtmConstants.ADD_CASH,method=RequestMethod.POST)
	public String addCash(@ModelAttribute("customerDetails")NewCashTransactionDetailsBean newCashTransactionDetailsBean, BindingResult result, ModelMap model) {
		logger.debug("addCash :START");
		if(StringUtils.isNotBlank(newCashTransactionDetailsBean.getCustomerDetails())){
			if(! newCashTransactionDetailsBean.getCustomerDetails().equals("#")){
				String [] customerDetailsArray=newCashTransactionDetailsBean.getCustomerDetails().split("###");
				newCashTransactionDetailsBean.setName(customerDetailsArray[0]);
				newCashTransactionDetailsBean.setCustomerId(customerDetailsArray[1]);
				newCashTransactionDetailsBean.setGodownNo(customerDetailsArray[2]);
			}
		}
		ResponseDTO response=cashTransactionServiceBO.validateAndSaveCashDetails(newCashTransactionDetailsBean);
		
		if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			model.addAttribute("message",response.getMessage());
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
			response=cashTransactionServiceBO.validateAndSearchCustomerDetails();
			NewCashTransactionDetailsBean newBillDetailsBean=new NewCashTransactionDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			model.addAttribute("cashPaidDetails",new NewCashTransactionDetailsBean());
			
		}
		else{
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("searchHappen","true");
			response=cashTransactionServiceBO.validateAndSearchCustomerDetails();
			NewCashTransactionDetailsBean newBillDetailsBean=new NewCashTransactionDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			model.addAttribute("cashPaidDetails",new NewCashTransactionDetailsBean());
			

		}
		logger.debug("addCash :END");
		return "addCashTransaction";
	}
}