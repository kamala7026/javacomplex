package com.shopping.global.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.NewCashTransactionDetailsBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.services.CashTransactionService;
import com.shopping.global.services.ResponseDTO;

@Component
public class CashTransactionServiceBO {

	final static Logger logger = LoggerFactory.getLogger(CashTransactionServiceBO.class);
	
	@Autowired
	private CashTransactionService cashTransactionService;
	
	
	public ResponseDTO validateAndSearchCustomerDetails() {
		logger.debug("validateAndSearchStockDetails :START");
		ResponseDTO response=null;
		try {
			
			NewCashTransactionDetailsBean newCashTransactionDetailsBean=cashTransactionService.searchCustomerDetails();
			response=new ResponseDTO();
			response.setResponseObject(newCashTransactionDetailsBean);
			response.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchCustomerDetails :END");
		return response;
	}
	
	public ResponseDTO validateAndSaveCashDetails(NewCashTransactionDetailsBean newCashTransactionDetailsBean) {
		logger.debug("validateAndSaveCashDetails :START");
		ResponseDTO response=null;
		try {
			response=cashTransactionService.validationForMandatoryField(newCashTransactionDetailsBean);
			if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
				response=cashTransactionService.saveCashRecord(newCashTransactionDetailsBean);
			}
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setResponseObject(e);
		}
		logger.debug("validateAndSaveCashDetails :END");
		return response;
	}
}
