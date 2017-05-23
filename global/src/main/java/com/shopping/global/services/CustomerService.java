package com.shopping.global.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.CustomerDAO;
import com.shopping.global.model.TdCustomerDetail;
import com.shopping.global.util.DateUtil;
@Service
public class CustomerService {

	final static Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private DateUtil dateUtil;
	public ResponseDTO validationForMandatoryField(CustomerDetailsBean customerDetails){
		logger.debug("validationForMandatoryField :START");
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		if(StringUtils.isEmpty(customerDetails.getGnumber())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Godown Numer can not be blank");
		}else if(StringUtils.isEmpty(customerDetails.getMobile())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Mobile Numer can not be blank");
		}else if(StringUtils.isEmpty(customerDetails.getName())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Name can not be blank");
		}
		logger.debug("validationForMandatoryField :END");
		return resposne;
	}
	public ResponseDTO searchCustomerDetails(WildCardSearchBean customerSearchDetails) throws Exception{
		logger.debug("searchCustomerDetails :START");
		ResponseDTO response=null;

		response=customerDAO.searchCustomerDetails(customerSearchDetails);
		logger.debug("searchCustomerDetails :START");
		return response;
	}
	public ResponseDTO searchCustomerDues(WildCardSearchBean customerSearchDetails) throws Exception{
		logger.debug("searchCustomerDues :START");
		ResponseDTO response=null;

		response=customerDAO.searchCustomerDues(customerSearchDetails);
		logger.debug("searchCustomerDues :END");
		return response;
	}
	public ResponseDTO searchCustomerDueDetails(WildCardSearchBean customerSearchDetails) throws Exception{
		logger.debug("searchCustomerDueDetails :START");
		ResponseDTO response=null;

		response=customerDAO.searchCustomerDueDetails(customerSearchDetails);
		logger.debug("searchCustomerDueDetails :END");
		return response;
	}
	public ResponseDTO searchCustomerPaymentDetails(WildCardSearchBean customerSearchDetails) throws Exception{
		logger.debug("searchCustomerPaymentDetails :START");
		ResponseDTO response=null;

		response=customerDAO.searchCustomerPaymentDetails(customerSearchDetails);
		logger.debug("searchCustomerPaymentDetails :END");
		return response;
	}
	
	public ResponseDTO saveCustomerDetails(CustomerDetailsBean customerDetails) throws Exception{
		logger.debug("saveCustomerDetails :START");
		ResponseDTO response=null;
		try {
			TdCustomerDetail customerDetailsForDAO=new TdCustomerDetail();
			customerDetailsForDAO.setAddress(customerDetails.getAddress());
			customerDetailsForDAO.setCity(customerDetails.getCity());
			customerDetailsForDAO.setDob(dateUtil.stringToDate(customerDetails.getDob(),"YYYY-MM-DD"));
			customerDetailsForDAO.setEmail(customerDetails.getEmail());
			customerDetailsForDAO.setLandline(customerDetails.getSphone());
			customerDetailsForDAO.setSecondaryPhone(customerDetails.getSphone());
			customerDetailsForDAO.setMobile(customerDetails.getMobile());
			customerDetailsForDAO.setName(customerDetails.getName());
			customerDetailsForDAO.setState(customerDetails.getState());
			customerDetailsForDAO.setGodownNo(customerDetails.getGnumber());
			response=customerDAO.saveCustomerDetails(customerDetailsForDAO);
		} catch (Exception e) {
			throw e;
		}		
		logger.debug("saveCustomerDetails :END");
		return response;
	}


}
