package com.shopping.global.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.BillDAO;
import com.shopping.global.dao.CustomerDAO;
import com.shopping.global.dao.StockDAO;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.exception.QuantityMoreException;
import com.shopping.global.model.TdProductQuanityDetail;
@Service
public class BillService {
	
	final static Logger logger = LoggerFactory.getLogger(BillService.class);
	
	@Autowired
	private StockDAO stockDAO;

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private BillDAO billDAO;
	
	public NewBillDetailsBean searchStockDetails(){
		logger.debug("searchStockDetails :START");
		NewBillDetailsBean newBilDetailsBean=new NewBillDetailsBean();
		try {
			List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=stockDAO.searchStockNames();
			List<CustomerSearchDTO> listofCustomers=customerDAO.fetchAllCustomers();
			newBilDetailsBean.setListofCustomers(listofCustomers);
			newBilDetailsBean.setProductQuanityDetailsDTOList(ProductQuanityDetailsDTOList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("searchStockDetails :END");
		return newBilDetailsBean;
	}
	public ResponseDTO validateAndSearchBathcNoDetails(String SearchItemDetails){
		logger.debug("validateAndSearchBathcNoDetails :START");
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		try {
			resposne=stockDAO.validateAndSearchBathcNoDetails(SearchItemDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("validateAndSearchBathcNoDetails :END");
		return resposne;
	}
	
	public synchronized  ResponseDTO  validateBillItem (ListOfProductQuanityDetailsDTO billItem) throws Exception{
		logger.debug("validateBillItem :START");
		ResponseDTO resposne=new ResponseDTO();
		resposne.setStatus(Constants.SUCCESS);
		List<TdProductQuanityDetail> stockDetailsList=new ArrayList<TdProductQuanityDetail>();
		try {
			//Same productId added twice
			for(int i=0;i<billItem.getBillItems().size();i++){
				String productId=billItem.getBillItems().get(i).getProductId();
				for(int j=i+1;j<billItem.getBillItems().size();j++){
					if(productId.equalsIgnoreCase(billItem.getBillItems().get(j).getProductId())){
						Integer tempquantity=billItem.getBillItems().get(j).getQuantity();
						Integer existQuantity=billItem.getBillItems().get(i).getQuantity();
						Integer finalQuantity= tempquantity + existQuantity;
						billItem.getBillItems().get(i).setQuantity(finalQuantity);
						billItem.getBillItems().remove(j);
					}
				}
			}
			//billItem.getBillItems().sort((o1, o2) -> o1.getProductId().compareTo(o2.getProductId()));
			Collections.sort(billItem.getBillItems(), new Comparator<NewBillProductDTO>(){
				  public int compare(NewBillProductDTO o1, NewBillProductDTO o2){
					    return o1.getProductId().compareTo(o2.getProductId());
					  }
					});
			stockDetailsList=stockDAO.fetchBillItem(billItem);
			//stockDetailsList.sort((o1, o2) -> o1.getProductId().compareTo(o2.getProductId()));
			Collections.sort(stockDetailsList, new Comparator<TdProductQuanityDetail>(){
				  public int compare(TdProductQuanityDetail o1, TdProductQuanityDetail o2){
					    return o1.getProductId().compareTo(o2.getProductId());
					  }
					});

			for(int i=0;i< billItem.getBillItems().size();i++){
				if(billItem.getBillItems().get(i).getProductId().equalsIgnoreCase(stockDetailsList.get(i).getProductId().toString())){
					if(billItem.getBillItems().get(i).getQuantity().intValue() > stockDetailsList.get(i).getProductQuantity().intValue() || billItem.getBillItems().get(i).getQuantity().intValue() ==0){
						throw new QuantityMoreException();
					}
				}
			}
			resposne=billDAO.saveBillDetails(billItem);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		logger.debug("validateBillItem :END");
		return resposne;
	}
	public ResponseDTO searchBillDetails(WildCardSearchBean billSearch) throws Exception{
		logger.debug("searchBillDetails :START");
		ResponseDTO response=null;

		response=billDAO.searchBillDetails(billSearch);
		logger.debug("searchBillDetails :START");
		return response;
	}
}
