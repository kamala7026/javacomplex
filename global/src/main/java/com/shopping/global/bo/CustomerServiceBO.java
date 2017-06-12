package com.shopping.global.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.services.CustomerService;
import com.shopping.global.services.ResponseDTO;



@Component
public class CustomerServiceBO {
	final static Logger logger = LoggerFactory.getLogger(CustomerServiceBO.class);
	@Autowired
	private CustomerService customerService;



	public ResponseDTO validateAndSaveCustomerDetails(CustomerDetailsBean customerDetails) {
		logger.debug("validateAndSaveCustomerDetails :START");
		ResponseDTO response=null;
		try {
			response=customerService.validationForMandatoryField(customerDetails);
			if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
				response=customerService.saveCustomerDetails(customerDetails);
			}
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			if(e.getCause().getMessage().contains("Duplicate")){
				response.setMessage("Customer is already present having same details.");
			}
			response.setResponseObject(e);
		}
		logger.debug("validateAndSaveCustomerDetails :END");
		return response;
	}
	public ResponseDTO validateAndSearchCustomerDetails(WildCardSearchBean customerSearchDetails) {
		logger.debug("validateAndSearchCustomerDetails :START");
		ResponseDTO response=null;
		try {

				response=customerService.searchCustomerDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchCustomerDetails :END");
		return response;
	}
	public ResponseDTO getCustomerDetails(CustomerSearchDTO customer) {
		logger.debug("getCustomerDetails :START");
		ResponseDTO response=null;
		try {

				response=customerService.getCustomerDetails(customer);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("getCustomerDetails :END");
		return response;
	}
	public ResponseDTO validateAndFetchCustomerDues(WildCardSearchBean customerSearchDetails) {
		logger.debug("validateAndFetchCustomerDues :START");
		ResponseDTO response=null;
		try {

				response=customerService.searchCustomerDues(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndFetchCustomerDues :END");
		return response;
	}

	public ResponseDTO validateAndFetchCustomerDueDetails(WildCardSearchBean customerSearchDetails) {
		logger.debug("validateAndFetchCustomerDueDetails :START");
		ResponseDTO response=null;
		try {

				response=customerService.searchCustomerDueDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndFetchCustomerDueDetails :END");
		return response;
	}
	public ResponseDTO validateAndFetchCustomerPaymentDetails(WildCardSearchBean customerSearchDetails) {
		logger.debug("validateAndFetchCustomerPaymentDetails :START");
		ResponseDTO response=null;
		try {
				response=customerService.searchCustomerPaymentDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndFetchCustomerPaymentDetails :END");
		return response;
	}
	public ResponseDTO updateCustomer(CustomerSearchDTO customer) {
		logger.debug("updateCustomer :START");
		ResponseDTO response=null;
		try {

				response=customerService.updateCustomer(customer);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("updateCustomer :END");
		return response;
	}
}
