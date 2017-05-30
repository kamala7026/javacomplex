package com.shopping.global.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.exception.QuantityMoreException;
import com.shopping.global.services.BillService;
import com.shopping.global.services.ResponseDTO;
@Component
public class BillServiceBO {
	final static Logger logger = LoggerFactory.getLogger(BillServiceBO.class);

	@Autowired
	private BillService billService;



	public ResponseDTO validateAndSearchStockDetails() {
		logger.debug("validateAndSearchStockDetails :START");
		ResponseDTO response=null;
		try {

			NewBillDetailsBean newBilDetailsBean=billService.searchStockDetails();
			response=new ResponseDTO();
			response.setResponseObject(newBilDetailsBean);
			response.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchStockDetails :END");
		return response;
	}
	public ResponseDTO validateAndSearchBathcNoDetails(String SearchItemDetails) {
		logger.debug("validateAndSearchBathcNoDetails :START");
		ResponseDTO response=null;
		try {

				response=billService.validateAndSearchBathcNoDetails(SearchItemDetails);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchBathcNoDetails :END");
		return response;
	}

	public ResponseDTO validateBillItem(ListOfProductQuanityDetailsDTO billItem) throws Exception {
		logger.debug("validateBillItem :START");
		ResponseDTO response=null;
		try {
			    prepareInputForService(billItem);
				response=billService.validateBillItem(billItem);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
			throw e;
		}
		logger.debug("validateBillItem :END");
		return response;
	}
	public void prepareInputForService(ListOfProductQuanityDetailsDTO billItem) throws QuantityMoreException{
		logger.debug("prepareInputForService :START");
		if(null !=billItem){
			if(! CollectionUtils.isEmpty(billItem.getBillItems())){
				for(NewBillProductDTO itemDetails: billItem.getBillItems()){
					if(! itemDetails.getProductName().equals("#")){
						String productNameInput=itemDetails.getProductName();
						String [] productNameSplited=productNameInput.split("###");
						itemDetails.setProductName(productNameSplited[1]);
						itemDetails.setProductId(productNameSplited[0]);
					}

				}
			}
			if(StringUtils.isNotBlank(billItem.getCustomerDetails())){
				if(! billItem.getCustomerDetails().equals("#")){
					String [] customerDetailsArray=billItem.getCustomerDetails().split("###");
					billItem.setCustomerName(customerDetailsArray[0]);
					billItem.setCustomerId(customerDetailsArray[1]);
					billItem.setGodownNo(customerDetailsArray[2]);
				}
			}
				billItem.setDueAmount(billItem.getBillAmount()-billItem.getPaidAmount());
				List<NewBillProductDTO> temporaryList=new ArrayList<NewBillProductDTO>();
				temporaryList.addAll(billItem.getBillItems());
				List<NewBillProductDTO> temporaryList2=new ArrayList<NewBillProductDTO>();
				for(int i=0;i< temporaryList.size();i++){
					if(!StringUtils.isEmpty(temporaryList.get(i).getProductId())){
						temporaryList2.add(temporaryList.get(i));
					}
				}
				if(temporaryList2.size() > 0){
					billItem.setBillItems(temporaryList2);
				}
				else{
					throw new QuantityMoreException();
				}
		}
		logger.debug("prepareInputForService :END");
	}

	public ResponseDTO validateAndSearchBillDetails(WildCardSearchBean billSearch) {
		logger.debug("validateAndSearchBillDetails :START");
		ResponseDTO response=null;
		try {

				response=billService.searchBillDetails(billSearch);
		} catch (Exception e) {
			response.setStatus(Constants.ERROR);
			response.setMessage(e.getMessage());
			response.setResponseObject(e);
		}
		logger.debug("validateAndSearchBillDetails :END");
		return response;
	}
}
