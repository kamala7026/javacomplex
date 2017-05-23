package com.shopping.global.services;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shopping.global.bean.AddStockBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.StockDAO;
import com.shopping.global.model.TdProductQuanityDetail;
import com.shopping.global.util.DateUtil;
@Service
public class StockService {

	final static Logger logger = LoggerFactory.getLogger(StockService.class);

	@Autowired
	private StockDAO stockDAO;

	@Autowired
	private DateUtil dateUtils;
	
	public ResponseDTO validationForMandatoryField(AddStockBean stockDetails){
		logger.debug("validationForMandatoryField :START");
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		if(StringUtils.isEmpty(stockDetails.getProductName())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("ProductName can not be blank");
		}else if(StringUtils.isEmpty(stockDetails.getPurchasePrice())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Puchase price can not be blank");
		}else if(StringUtils.isEmpty(stockDetails.getQuantity())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Qunatity can not be blank");
		}else if(StringUtils.isEmpty(stockDetails.getPurchaseVat())){
			resposne.setStatus(Constants.ERROR);
			resposne.setMessage("Puchase vat can not be blank");
		}
		logger.debug("validationForMandatoryField :END");
		return resposne;
	}
	
	
	
	public ResponseDTO saveNewStockDetails(AddStockBean stockDetails) throws Exception{
		logger.debug("saveNewStockDetails :START");
		ResponseDTO response=null;
		try {
			TdProductQuanityDetail tdProductQuanityDetail=new TdProductQuanityDetail();
			tdProductQuanityDetail.setProductName(stockDetails.getProductName());
			tdProductQuanityDetail.setProductDesc(stockDetails.getProductDescription());
			tdProductQuanityDetail.setProductBatchNo(stockDetails.getBatch());
			tdProductQuanityDetail.setProductExpiryDt(dateUtils.stringToDate(stockDetails.getExpdate(),Constants.DEFAULT_DATE_FORMAT));
			tdProductQuanityDetail.setProductExtraInfo(stockDetails.getProductExtraInfo());
			tdProductQuanityDetail.setProductLocation(stockDetails.getProductLocation());
			tdProductQuanityDetail.setProductMfgDt(dateUtils.stringToDate(stockDetails.getMfgdate(),Constants.DEFAULT_DATE_FORMAT));
			tdProductQuanityDetail.setProductPurchasePrice(new Double(stockDetails.getPurchasePrice()));
			tdProductQuanityDetail.setProductPurchaseVat(new Double(stockDetails.getPurchaseVat()));
			tdProductQuanityDetail.setProductQuantity(new BigInteger(stockDetails.getQuantity()));
			tdProductQuanityDetail.setProductSellingPrice(new Double(org.apache.commons.lang3.StringUtils.isNotBlank(stockDetails.getSellingPrice())? stockDetails.getSellingPrice():stockDetails.getPurchasePrice()));
			tdProductQuanityDetail.setProductSellVat(new Double(org.apache.commons.lang3.StringUtils.isNotBlank(stockDetails.getSellingVat())? stockDetails.getSellingVat():stockDetails.getPurchaseVat()));
			response=stockDAO.saveStockDetails(tdProductQuanityDetail);
		} catch (Exception e) {
			throw e;
		}		
		logger.debug("saveNewStockDetails :END");
		return response;
	}
	public ResponseDTO updateStockDetails(AddStockBean stockDetails) throws Exception{
		logger.debug("updateStockDetails :START");
		ResponseDTO response=null;
		try {
			TdProductQuanityDetail tdProductQuanityDetail=new TdProductQuanityDetail();
			tdProductQuanityDetail.setProductName(stockDetails.getProductName());
			tdProductQuanityDetail.setProductDesc(stockDetails.getProductDescription());
			tdProductQuanityDetail.setProductBatchNo(stockDetails.getBatch());
			tdProductQuanityDetail.setProductExpiryDt(dateUtils.stringToDate(stockDetails.getExpdate(),Constants.DATE_FORMAT_STOCK));
			tdProductQuanityDetail.setProductExtraInfo(stockDetails.getProductExtraInfo());
			tdProductQuanityDetail.setProductLocation(stockDetails.getProductLocation());
			tdProductQuanityDetail.setProductMfgDt(dateUtils.stringToDate(stockDetails.getMfgdate(),Constants.DATE_FORMAT_STOCK));
			tdProductQuanityDetail.setProductPurchasePrice(new Double(stockDetails.getPurchasePrice()));
			tdProductQuanityDetail.setProductPurchaseVat(new Double(stockDetails.getPurchaseVat()));
			tdProductQuanityDetail.setProductQuantity(new BigInteger(stockDetails.getQuantity()));
			tdProductQuanityDetail.setProductSellingPrice(new Double(stockDetails.getSellingPrice()));
			tdProductQuanityDetail.setProductSellVat(new Double(stockDetails.getSellingVat()));
			tdProductQuanityDetail.setProductId(new BigInteger(stockDetails.getProductId()));
			response=stockDAO.updateStockDetails(tdProductQuanityDetail);
		} catch (Exception e) {
			throw e;
		}		
		logger.debug("updateStockDetails :END");
		return response;
	}
	public ResponseDTO searchStockDetails(WildCardSearchBean stockSearchDetails) throws Exception{
		logger.debug("searchStockDetails :START");
		ResponseDTO response=null;

		response=stockDAO.searchStockDetails(stockSearchDetails);
		logger.debug("searchStockDetails :END");
		return response;
	}
	public ResponseDTO searchExpiryStockDetails(String stockSearchDetails) throws Exception{
		logger.debug("searchStockDetails :START");
		ResponseDTO response=null;

		//response=stockDAO.searchExpiryStockDetails(stockSearchDetails);
		logger.debug("searchStockDetails :END");
		return response;
	}
	public ResponseDTO searchProdcuDetails(WildCardSearchBean productSearchDetails) throws Exception{
		logger.debug("searchProdcuDetails :START");
		ResponseDTO response=null;

		response=stockDAO.searchProductDetails(productSearchDetails);
		logger.debug("searchProdcuDetails :END");
		return response;
	}
	public ResponseDTO fetchAllStockDetails() throws Exception{
		logger.debug("fetchAllStockDetails :START");
		ResponseDTO response=null;

		response=stockDAO.fetchAllStockDetails();
		logger.debug("fetchAllStockDetails :END");
		return response;
	}

}
