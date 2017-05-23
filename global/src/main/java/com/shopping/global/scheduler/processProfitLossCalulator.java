package com.shopping.global.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dao.BillDAO;
import com.shopping.global.dao.StockDAO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.model.TdItemDetailsForBill;
import com.shopping.global.model.TdPurchaseHistory;
import com.shopping.global.services.ResponseDTO;

@Component
public class processProfitLossCalulator {

	@Autowired
	private BillDAO billDAO;
	
	@Autowired
	private StockDAO stockDAO;
	
	@Scheduled(fixedDelay = 3600000)
	private void processProfitLossCal(){
		try {
			Double totalProfit=(double) 0;
			List<TdPurchaseHistory> purchaseRecord=billDAO.searchBillDetailsForProcess();
			if(null !=purchaseRecord){
				for(TdPurchaseHistory currentBill :purchaseRecord){
					totalProfit=totalProfit+findProfitForBill(currentBill);
					Boolean transactionDone=billDAO.saveProfitDetails(totalProfit);
					if(transactionDone){
						updateProcessBillDetails(currentBill);
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateProcessBillDetails(TdPurchaseHistory currentBill) throws Exception{
		currentBill.setProcessed("D");
		billDAO.updateitemDetailsForBill(currentBill);
	}
	private Double findProfitForBill(TdPurchaseHistory currentBill) throws Exception{
		Double totalProfitForBill=(double) 0;
		List<TdItemDetailsForBill> items=billDAO.fetchItemsFromBill(currentBill.getBillNo());
		if(!CollectionUtils.isEmpty(items)){
			for(TdItemDetailsForBill item :items){
				totalProfitForBill=totalProfitForBill+findProfitForItem(item);
			}
		}
		return totalProfitForBill;
	}
	private Double findProfitForItem(TdItemDetailsForBill currentItemSellDetails) throws Exception{
		Double totalProfitForOneItem=(double) 0;
		WildCardSearchBean searchProduct=new WildCardSearchBean();
		searchProduct.setSearchString(currentItemSellDetails.getProductId().toString());
		ResponseDTO responseDTO=stockDAO.searchProductDetails(searchProduct);
		if(responseDTO.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList= (List<ProductQuanityDetailsDTO>) responseDTO.getResponseObject();
			if(null!=ProductQuanityDetailsDTOList){
				ProductQuanityDetailsDTO currentItemPurchaseDetails= ProductQuanityDetailsDTOList.get(0);
				totalProfitForOneItem=((currentItemSellDetails.getSellPrice()* currentItemSellDetails.getQuantity())-(currentItemSellDetails.getSellPrice()*currentItemSellDetails.getQuantity()*(currentItemSellDetails.getSellVat()/100)))
				-((currentItemPurchaseDetails.getProductPurchasePrice()*currentItemSellDetails.getQuantity())-(currentItemPurchaseDetails.getProductPurchasePrice()*currentItemSellDetails.getQuantity()*(currentItemPurchaseDetails.getProductPurchaseVat()/100)));
			}
			
		}
		return totalProfitForOneItem;
	}
}
