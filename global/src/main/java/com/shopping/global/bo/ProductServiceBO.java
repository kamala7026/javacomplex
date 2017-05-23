package com.shopping.global.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.AddStockBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.services.StockService;



@Component
public class ProductServiceBO {
	
	final static Logger logger = LoggerFactory.getLogger(ProductServiceBO.class);
	@Autowired
	private StockService stockService;



	public ResponseDTO validateAndSaveProductDetails(AddStockBean stockDetails) {
		logger.debug("validateAndSaveProductDetails :START");
		ResponseDTO response=null;
		try {
			response=stockService.validationForMandatoryField(stockDetails);
			if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
				response=stockService.saveNewStockDetails(stockDetails);
			}
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSaveProductDetails :END");
		return response;
	}
	public ResponseDTO validateAndUpdateProductDetails(AddStockBean stockDetails) {
		logger.debug("validateAndUpdateProductDetails :START");
		ResponseDTO response=null;
		try {
			response=stockService.validationForMandatoryField(stockDetails);
			if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
				response=stockService.updateStockDetails(stockDetails);
			}
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndUpdateProductDetails :END");
		return response;
	}
	public ResponseDTO validateAndSearchStockDetails(WildCardSearchBean stockSearchDetails) {
		logger.debug("validateAndSearchStockDetails :START");
		ResponseDTO response=null;
		try {
			
				response=stockService.searchStockDetails(stockSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchStockDetails :END");
		return response;
	}
	public ResponseDTO validateAndSearchExpiryStockDetails(String stockSearchDetails) {
		logger.debug("validateAndSearchStockDetails :START");
		ResponseDTO response=new ResponseDTO();
		try {
			
				response=stockService.searchExpiryStockDetails(stockSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchStockDetails :END");
		return response;
	}
	public ResponseDTO validateAndFetchProductDetails(WildCardSearchBean customerSearchDetails) {
		logger.debug("validateAndFetchProductDetails :START");
		ResponseDTO response=null;
		try {
			
				response=stockService.searchProdcuDetails(customerSearchDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndFetchProductDetails :END");
		return response;
	}
	public ResponseDTO fetchAllStockDetails() {
		logger.debug("fetchAllStockDetails :START");
		ResponseDTO response=null;
		try {
			
				response=stockService.fetchAllStockDetails();
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("fetchAllStockDetails :END");
		return response;
	}
}
