package com.shopping.global.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.exception.UnknownDbError;
import com.shopping.global.model.TdCustomerBalance;
import com.shopping.global.model.TdCustomerBalanceDetail;
import com.shopping.global.model.TdCustomerDetail;
import com.shopping.global.model.TdCustomerSearch;
import com.shopping.global.model.TdItemDetailsForBill;
import com.shopping.global.model.TdProductQuanityDetail;
import com.shopping.global.model.TdProfitLoss;
import com.shopping.global.model.TdPurchaseHistory;
import com.shopping.global.services.ResponseDTO;



@Component
public class BillDAO {

	final static Logger logger = LoggerFactory.getLogger(BillDAO.class);


	@Autowired
	private StockDAO stockDAO;

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ResponseDTO saveBillDetails(ListOfProductQuanityDetailsDTO billItem) throws Exception{
		logger.debug("saveBillDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			TdPurchaseHistory tdPurchaseHistory	=new TdPurchaseHistory();
			Boolean productQuantityStatus=false;
			Boolean customerDueStatus=false;
			Boolean customerTotalDueStatus=false;
			Boolean updateItemDetailsForBillStatus=false;
			tdPurchaseHistory.setBasicAmount(billItem.getBasicAmount());
			tdPurchaseHistory.setBillAmount(billItem.getBillAmount());
			tdPurchaseHistory.setBillDate(billItem.getBillDate());
			if(StringUtils.isNotBlank(billItem.getCustomerId())){
				List<TdCustomerDetail> customerDetailsList=session.createQuery("from TdCustomerDetail where customerId = :customerId").setParameter("customerId", new BigInteger(billItem.getCustomerId())).list();
				if(customerDetailsList.size()!=0){
					billItem.setCustomerDetails("<b>"+customerDetailsList.get(0).getName()+"<b></br>"+customerDetailsList.get(0).getAddress());
				}
				tdPurchaseHistory.setCustomerId(new BigInteger(billItem.getCustomerId()));
		    }
			else{
				tdPurchaseHistory.setCustomerId(null);
			}
			tdPurchaseHistory.setDueAmount(billItem.getDueAmount());
			tdPurchaseHistory.setGodownNo(billItem.getGodownNo());
			tdPurchaseHistory.setPaidAmount(billItem.getPaidAmount());
			tdPurchaseHistory.setPaymentType("CASH");
			tdPurchaseHistory.setVatAmount(billItem.getVatAmount());
			try {
				tx.begin();
				session.save(tdPurchaseHistory);
				tx.commit();
				if(!tdPurchaseHistory.getBillNo().toString().isEmpty()){
					 productQuantityStatus=updateQuantityDetails(billItem);
					 updateItemDetailsForBillStatus=updateItemDetailsForBill(billItem,tdPurchaseHistory.getBillNo());
					 customerDueStatus=updateCustomerDues(billItem,tdPurchaseHistory.getBillNo());
					 customerTotalDueStatus=updateCustomerTotalDue(billItem);
				}
				if(productQuantityStatus && customerDueStatus && customerTotalDueStatus && updateItemDetailsForBillStatus){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setMessage(tdPurchaseHistory.getBillNo().toString());
				}else{
					throw new UnknownDbError();
				}

			} catch (Exception e) {
				tx.rollback();
				responseDTO.setStatus(Constants.FAILURE);
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					responseDTO.setStatus(Constants.FAILURE);
					throw e2;
				}
			}

		} catch (Exception e) {
			responseDTO.setStatus(Constants.FAILURE);
			throw e;
		}
		logger.debug("saveBillDetails :END");
		return responseDTO;
	}
	private Boolean updateCustomerDues(ListOfProductQuanityDetailsDTO billItem,BigInteger billNo){
		logger.debug("updateCustomerDues :START");
		Boolean customerDueStatus=false;
		if(StringUtils.isNotBlank(billItem.getCustomerId())){
			try {

				Session session=this.getSessionFactory().openSession();
				Transaction tx=session.getTransaction();
				TdCustomerBalanceDetail tdCustomerBalanceDetail	=new TdCustomerBalanceDetail();
				tdCustomerBalanceDetail.setBillAmount(billItem.getBillAmount());
				tdCustomerBalanceDetail.setBillDate(billItem.getBillDate());
				tdCustomerBalanceDetail.setBillNo(billNo);
				tdCustomerBalanceDetail.setCustomerId(new BigInteger(billItem.getCustomerId()));
				tdCustomerBalanceDetail.setDueAmount(billItem.getDueAmount());
				tdCustomerBalanceDetail.setGoddownNo(billItem.getGodownNo());
				tdCustomerBalanceDetail.setName(billItem.getCustomerName());
				tdCustomerBalanceDetail.setPaidAmount(billItem.getPaidAmount());
				try {
					tx.begin();
					session.save(tdCustomerBalanceDetail);
					tx.commit();
					if(!tdCustomerBalanceDetail.getBalanceDetailsCode().toString().isEmpty()){
						customerDueStatus=true;
					}

				} catch (Exception e) {
					tx.rollback();
					throw e;
				}finally{
					try {
						session.close();
					} catch (Exception e2) {
						tx.rollback();
						throw e2;
					}
				}

			} catch (Exception e) {
				throw e;
			}
		}
		else{
			customerDueStatus=true;
		}
		logger.debug("updateCustomerDues :END");
		return customerDueStatus;
	}
	private Boolean updateItemDetailsForBill(ListOfProductQuanityDetailsDTO billItem,BigInteger billNo) throws Exception{
		logger.debug("updateItemDetailsForBill :START");
		Boolean itemDetailsStatus=false;
		try {
			for(NewBillProductDTO newBillProductDTO :billItem.getBillItems()){
				updateitemDetailsForBill(newBillProductDTO,billNo);
			}
			itemDetailsStatus=true;
		}
		catch (Exception e) {
			throw e;
		}
		logger.debug("updateItemDetailsForBill :END");
		return itemDetailsStatus;
	}
	private void updateitemDetailsForBill(NewBillProductDTO billedItem,BigInteger billNo) throws Exception{
		logger.debug("updateitemDetailsForBill :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			TdItemDetailsForBill tdItemDetailsForBill=new TdItemDetailsForBill();
			tdItemDetailsForBill.setBillNo(billNo);
			tdItemDetailsForBill.setProductId(new BigInteger(billedItem.getProductId()));
			tdItemDetailsForBill.setQuantity(billedItem.getQuantity());
			tdItemDetailsForBill.setSellPrice(billedItem.getPrice());
			tdItemDetailsForBill.setSellVat(billedItem.getSellvat());
			try {
				tx.begin();
				session.save(tdItemDetailsForBill);
				tx.commit();
				if(tdItemDetailsForBill.getBillItemDetails().toString().isEmpty()){
					throw new UnknownDbError();
				}
			}
			catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}

		}
		catch (Exception e) {
			throw e;
		}
		logger.debug("updateitemDetailsForBill :END");
	}
	private Boolean updateCustomerTotalDue(ListOfProductQuanityDetailsDTO billItem){
		logger.debug("updateCustomerTotalDue :START");
		Boolean customerTotalDueStatus=false;
		if(StringUtils.isNotBlank(billItem.getCustomerId())){
			try {
				Session session=this.getSessionFactory().openSession();
				Transaction tx=session.getTransaction();
				try {
					tx.begin();
					Object o=session.get(TdCustomerBalance.class,new BigInteger(billItem.getCustomerId()));
					if(null != o){
						TdCustomerBalance tdCustomerBalance=(TdCustomerBalance)o;
						Double dbQuanity=tdCustomerBalance.getTotalBalance();
						Double val= dbQuanity+billItem.getDueAmount();
						tdCustomerBalance.setTotalBalance(val);
						tx.commit();
						customerTotalDueStatus=true;
					}
					else{
						TdCustomerBalance tdCustomerBalance=new TdCustomerBalance();
						tdCustomerBalance.setCustomerId(new BigInteger(billItem.getCustomerId()));
						tdCustomerBalance.setGodownno(billItem.getGodownNo());
						tdCustomerBalance.setName(billItem.getCustomerName());
						tdCustomerBalance.setTotalBalance(billItem.getDueAmount());
						session.save(tdCustomerBalance);
						tx.commit();
						customerTotalDueStatus=true;
					}

				} catch (Exception e) {
					tx.rollback();
					throw e;
				}finally{
					try {
						session.close();
					} catch (Exception e2) {
						tx.rollback();
						throw e2;
					}
				}

			} catch (Exception e) {
				throw e;
			}
		}
		else{
			customerTotalDueStatus=true;
		}
		logger.debug("updateCustomerTotalDue :END");
		return customerTotalDueStatus;
	}
	private Boolean updateQuantityDetails(ListOfProductQuanityDetailsDTO billItem){
		logger.debug("updateQuantityDetails :START");
		Boolean productQuantityStatus=false;
		try {
			for(NewBillProductDTO newBillProductDTO :billItem.getBillItems()){
				productQuantityStatus=updateQuantity(newBillProductDTO);
				if(productQuantityStatus == false){
					return productQuantityStatus;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		logger.debug("updateQuantityDetails :END");
		return productQuantityStatus;
	}

	private Boolean updateQuantity(NewBillProductDTO billedItem){
		logger.debug("updateQuantity :START");
		Boolean updateQuantity=false;
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Object o=session.get(TdProductQuanityDetail.class,new BigInteger(billedItem.getProductId()));
				if(null != o){
					TdProductQuanityDetail tdProductQuanityDetail=(TdProductQuanityDetail)o;
					Integer dbQuanity=tdProductQuanityDetail.getProductQuantity().intValue();
					Integer val= dbQuanity-billedItem.getQuantity().intValue();
					tdProductQuanityDetail.setProductQuantity( BigInteger.valueOf(val.intValue()));
					tx.commit();
					updateQuantity=true;
				}
				else{
					updateQuantity=false;
				}
			} catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}

		} catch (Exception e) {
			throw e;
		}
		logger.debug("updateQuantity :END");
		return updateQuantity;
	}

	public ResponseDTO searchBillDetails(WildCardSearchBean billSearch) throws Exception{
		logger.debug("searchBillDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Object o=session.get(TdPurchaseHistory.class,new BigInteger(billSearch.getSearchString()));
				if(null != o){
					TdPurchaseHistory tdBillDetails=(TdPurchaseHistory)o;
					ListOfProductQuanityDetailsDTO billItem=new ListOfProductQuanityDetailsDTO();
					billItem.setBillAmount(tdBillDetails.getBillAmount());
					billItem.setBillDate(tdBillDetails.getBillDate());
					billItem.setBillNumber(tdBillDetails.getBillNo().toString());
					billItem.setGodownNo(tdBillDetails.getGodownNo());
					billItem.setPaidAmount(tdBillDetails.getPaidAmount());
					billItem.setDueAmount(tdBillDetails.getDueAmount());
					billItem.setBasicAmount(tdBillDetails.getBasicAmount());
					billItem.setVatAmount(tdBillDetails.getVatAmount());
					List<TdCustomerDetail> customerDetailsList=session.createQuery("from TdCustomerDetail where customerId = :customerId").setParameter("customerId", tdBillDetails.getCustomerId()).list();
					if(customerDetailsList.size()!=0){
						billItem.setCustomerName("<b>"+customerDetailsList.get(0).getName()+"<b></br>"+customerDetailsList.get(0).getAddress());
					}
					billItem.setBillItems(setItemsFromBill(billSearch));
					responseDTO.setResponseObject(billItem);
					responseDTO.setStatus(Constants.SUCCESS);
				}
			} catch (Exception e) {
				tx.rollback();
				responseDTO.setStatus(Constants.FAILURE);
				e.printStackTrace();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					responseDTO.setStatus(Constants.FAILURE);
					throw e2;
				}
			}
		} catch (Exception e) {
			responseDTO.setStatus(Constants.FAILURE);
			throw e;
		}
		logger.debug("searchBillDetails :END");
		return responseDTO;
	}
	List<NewBillProductDTO> setItemsFromBill(WildCardSearchBean billSearch) throws Exception{
		logger.debug("setItemsFromBill :START");
		List<NewBillProductDTO> itemsFromBill=new ArrayList<NewBillProductDTO>();
		List<TdItemDetailsForBill> items=this.fetchItemsFromBill(new BigInteger(billSearch.getSearchString()));
		for(TdItemDetailsForBill itemsFromDB:items ){
			NewBillProductDTO billProductDTO=new NewBillProductDTO();
			billProductDTO.setProductId(itemsFromDB.getProductId().toString());
			TdProductQuanityDetail tdProductQuanityDetail=stockDAO.fetchProductDetails(itemsFromDB.getProductId().toString());
			billProductDTO.setPdesc(tdProductQuanityDetail.getProductDesc());
			billProductDTO.setProductName(tdProductQuanityDetail.getProductName());
			billProductDTO.setQuantity(itemsFromDB.getQuantity());
			billProductDTO.setPrice(itemsFromDB.getSellPrice());
			billProductDTO.setSellvat(itemsFromDB.getSellVat());
			billProductDTO.setTotalPrice(itemsFromDB.getSellPrice()*itemsFromDB.getQuantity());
			itemsFromBill.add(billProductDTO);
		}
		logger.debug("setItemsFromBill :END");
		return itemsFromBill;
	}
	public List<TdPurchaseHistory> searchBillDetailsForProcess() throws Exception{
		logger.debug("searchBillDetailsForProcess :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdPurchaseHistory> purchaseRecord=session.createQuery("from TdPurchaseHistory where processed is null").list();
				return purchaseRecord;
			} catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<TdItemDetailsForBill> fetchItemsFromBill(BigInteger billSearch) throws Exception{
		logger.debug("fetchItemsFromBill :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				List<TdItemDetailsForBill> items=session.createQuery("from TdItemDetailsForBill where billNo = :searchString").setParameter("searchString",billSearch).list();
				return items;
			} catch (Exception e) {
				tx.rollback();
				responseDTO.setStatus(Constants.FAILURE);
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					responseDTO.setStatus(Constants.FAILURE);
					throw e2;
				}
			}
		} catch (Exception e) {
			responseDTO.setStatus(Constants.FAILURE);
			throw e;
		}
	}

	public void updateitemDetailsForBill(TdPurchaseHistory currentBill) throws Exception{
		logger.debug("updateitemDetailsForBill :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();

			try {
				tx.begin();
				session.update(currentBill);
				tx.commit();

			}
			catch (Exception e) {
				tx.rollback();
				throw e;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					throw e2;
				}
			}

		}
		catch (Exception e) {
			throw e;
		}
		logger.debug("updateitemDetailsForBill :END");
	}

	public Boolean saveProfitDetails(Double totalProfit) throws Exception{
		logger.debug("saveProfitDetails :START");
		Boolean transactionDone=false;
			try {
				Session session=this.getSessionFactory().openSession();
				Transaction tx=session.getTransaction();
				try {
					tx.begin();
						TdProfitLoss profitLoss=new TdProfitLoss();
						profitLoss.setDay(new Date());
						profitLoss.setAmount(totalProfit);
						session.save(profitLoss);
						tx.commit();
						transactionDone=true;


				} catch (Exception e) {
					tx.rollback();
					throw e;
				}finally{
					try {
						session.close();
					} catch (Exception e2) {
						tx.rollback();
						throw e2;
					}
				}

			} catch (Exception e) {
				throw e;
			}


		logger.debug("saveProfitDetails :END");
		return transactionDone;
	}


}
