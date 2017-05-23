package com.shopping.global.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shopping.global.bean.NewCashTransactionDetailsBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.CashRecordDAO;
import com.shopping.global.dao.CustomerDAO;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.model.TdCashTransaction;
@Service
public class CashTransactionService {
	
	final static Logger logger = LoggerFactory.getLogger(CashTransactionService.class);

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CashRecordDAO cashRecordDAO;
	
	public NewCashTransactionDetailsBean searchCustomerDetails() throws Exception{
		logger.debug("searchStockDetails :START");
		NewCashTransactionDetailsBean newCashTransactionDetailsBean=new NewCashTransactionDetailsBean();
		try {
			List<CustomerSearchDTO> listofCustomers=customerDAO.fetchAllCustomers();
			newCashTransactionDetailsBean.setListofCustomers(listofCustomers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		logger.debug("searchStockDetails :END");
		return newCashTransactionDetailsBean;
	}
	
	public ResponseDTO validationForMandatoryField(NewCashTransactionDetailsBean newCashTransactionDetailsBean){
		logger.debug("validationForMandatoryField :START");
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		if(StringUtils.isEmpty(newCashTransactionDetailsBean.getGodownNo())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Choose Customer...");
		}else if(StringUtils.isEmpty(newCashTransactionDetailsBean.getAmount())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Amount can not be blank");
		}else if(StringUtils.isEmpty(newCashTransactionDetailsBean.getName())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Name can not be blank");
		}
		logger.debug("validationForMandatoryField :END");
		return resposne;
	}
	public ResponseDTO saveCashRecord(NewCashTransactionDetailsBean newCashTransactionDetailsBean) throws Exception{
		logger.debug("saveCustomerDetails :START");
		ResponseDTO response=null;
		try {
			TdCashTransaction tdCashTransaction=new TdCashTransaction();
			tdCashTransaction.setAmount(newCashTransactionDetailsBean.getAmount());
			tdCashTransaction.setCashRecordDate(new Date());
			tdCashTransaction.setCustomerId(new BigInteger(newCashTransactionDetailsBean.getCustomerId()));
			tdCashTransaction.setGoddownNo(newCashTransactionDetailsBean.getGodownNo());
			tdCashTransaction.setName(newCashTransactionDetailsBean.getName());
			tdCashTransaction.setPaymentType(newCashTransactionDetailsBean.getTypeOfTransact());
			response=cashRecordDAO.saveCashRecord(tdCashTransaction);
		} catch (Exception e) {
			throw e;
		}		
		logger.debug("saveCustomerDetails :END");
		return response;
	}
	
}
