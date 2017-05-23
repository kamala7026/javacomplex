package com.shopping.global.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.model.TdProductQuanityDetail;
import com.shopping.global.model.TdStockDetail;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.util.DateUtil;



@Component
public class StockDAO {

	final static Logger logger = LoggerFactory.getLogger(StockDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DateUtil dateUtils;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ResponseDTO searchStockDetails(WildCardSearchBean stockSearchDetails) throws Exception{
		logger.debug("searchStockDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdStockDetail> stockSearchDetailsList=session.createQuery("from TdStockDetail where productName like :searchString or product_desc like :searchString or productId like :searchString").setParameter("searchString", "%"+stockSearchDetails.getSearchString()+"%").list();
				if(stockSearchDetailsList.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(stockSearchDetailsList);
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
		logger.debug("searchStockDetails :END");
		return responseDTO;
	}
//	public ResponseDTO searchExpiryStockDetails(String stockSearchDetails) throws Exception{
//		logger.debug("searchStockDetails :START");
//		ResponseDTO responseDTO=new ResponseDTO();
//		List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=new ArrayList<ProductQuanityDetailsDTO>();
//		try {
//			Session session=this.getSessionFactory().openSession();
//			Transaction tx=session.getTransaction();
//			try {
//				tx.begin();
//				@SuppressWarnings("unchecked")
//				List<TdProductQuanityDetail> stockSearchDetailsList= session.createCriteria(TdProductQuanityDetail.class)
//				.add( Restrictions.le("productExpiryDt", dateUtils.stringToDate(stockSearchDetails,Constants.DEFAULT_DATE_FORMAT) ) ).list();
//				
//					if(stockSearchDetailsList!=null){
//						if(stockSearchDetailsList.size()!=0){
//							for(TdProductQuanityDetail stockDetails:stockSearchDetailsList){
//								ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
//								productQuanityDetailsDTO=prepareStockDetailsObject(stockDetails);
//								ProductQuanityDetailsDTOList.add(productQuanityDetailsDTO);
//							}
//
//						}
//					}
//					responseDTO.setResponseObject(ProductQuanityDetailsDTOList);
//			} catch (Exception e) {
//				tx.rollback();
//				responseDTO.setStatus(Constants.FAILURE);
//				throw e;
//			}finally{
//				try {
//					session.close();
//				} catch (Exception e2) {
//					tx.rollback();
//					responseDTO.setStatus(Constants.FAILURE);
//					throw e2;
//				}
//			}
//		} catch (Exception e) {
//			responseDTO.setStatus(Constants.FAILURE);
//			throw e;
//		}
//		logger.debug("searchStockDetails :END");
//		return responseDTO;
//	}
	public ResponseDTO saveStockDetails(TdProductQuanityDetail tdProductQuanityDetail) throws Exception{
		logger.debug("saveStockDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				session.save(tdProductQuanityDetail);
				tx.commit();
				responseDTO.setMessage(tdProductQuanityDetail.getProductId().toString());
				responseDTO.setStatus(Constants.SUCCESS);
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
		logger.debug("saveStockDetails :END");
		return responseDTO;
	}
	public ResponseDTO updateStockDetails(TdProductQuanityDetail tdProductQuanityDetail) throws Exception{
		logger.debug("updateStockDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Object o=session.get(TdProductQuanityDetail.class,tdProductQuanityDetail.getProductId());
				if(null != o){
					Boolean mfgDateCompareFlag=false;
					Boolean expiryDateCompare=false;
					TdProductQuanityDetail tdProductDetails=(TdProductQuanityDetail)o;
					BigInteger dbQuanity=tdProductDetails.getProductQuantity();
					Date dbMfgDateOld=  tdProductDetails.getProductMfgDt();
					Date dbExpiryDateOld=tdProductDetails.getProductExpiryDt();
					String dbBatchNo=tdProductDetails.getProductBatchNo();
					Date dbMfgDate=dateUtils.dateToDate(dbMfgDateOld,Constants.DATE_FORMAT_STOCK);
					Date dbExpiryDate=dateUtils.dateToDate(dbExpiryDateOld,Constants.DATE_FORMAT_STOCK);
					if(null != dbMfgDate && null != tdProductQuanityDetail.getProductMfgDt()){
						if(dbMfgDate.compareTo(tdProductQuanityDetail.getProductMfgDt())==0){
							mfgDateCompareFlag=true;
						}
					}
					if(null == dbMfgDate && null == tdProductQuanityDetail.getProductMfgDt()){
						mfgDateCompareFlag=true;
					}
					if(null != dbExpiryDate && null != tdProductQuanityDetail.getProductExpiryDt()){
						if(dbExpiryDate.compareTo(tdProductQuanityDetail.getProductExpiryDt())==0){
							expiryDateCompare=true;
						}
					}
					if(null == dbExpiryDate && null == tdProductQuanityDetail.getProductExpiryDt()){
						expiryDateCompare=true;
					}
					
					if((StringUtils.equalsIgnoreCase(dbBatchNo, tdProductQuanityDetail.getProductBatchNo()))
					  && mfgDateCompareFlag && expiryDateCompare){
							BigInteger val= dbQuanity.add(tdProductQuanityDetail.getProductQuantity());
							tdProductDetails.setProductQuantity(val);
							tx.commit();
							responseDTO.setMessage(tdProductQuanityDetail.getProductId().toString());
							responseDTO.setStatus(Constants.SUCCESS);
					}else{
						session.save(tdProductQuanityDetail);
						tx.commit();
						responseDTO.setMessage(tdProductQuanityDetail.getProductId().toString());
						responseDTO.setStatus(Constants.SUCCESS);
					}
					
				}
				else{
					session.save(tdProductQuanityDetail);
					tx.commit();
					responseDTO.setMessage(tdProductQuanityDetail.getProductId().toString());
					responseDTO.setStatus(Constants.SUCCESS);
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
		logger.debug("updateStockDetails :END");
		return responseDTO;
	}
	public List<ProductQuanityDetailsDTO> searchStockNames() throws Exception{
		logger.debug("searchStockNames :START");
		List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=new ArrayList<ProductQuanityDetailsDTO>();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdProductQuanityDetail> stockDetailsList=session.createQuery("from TdProductQuanityDetail where productQuantity > 0").list();
				if(stockDetailsList!=null){
					if(stockDetailsList.size()!=0){
						for(TdProductQuanityDetail stockDetails:stockDetailsList){
							ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
							productQuanityDetailsDTO=prepareStockDetailsObject(stockDetails);
							ProductQuanityDetailsDTOList.add(productQuanityDetailsDTO);
						}

					}
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
		logger.debug("searchStockNames :END");
		return ProductQuanityDetailsDTOList;
	}
	private ProductQuanityDetailsDTO prepareStockDetailsObject(TdProductQuanityDetail stockDetail){
		logger.debug("prepareStockDetailsObject :START");
		ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
		productQuanityDetailsDTO.setProduct_desc(stockDetail.getProductDesc());
		productQuanityDetailsDTO.setProductBatchNo(stockDetail.getProductBatchNo());
		productQuanityDetailsDTO.setProductExpiryDt(stockDetail.getProductExpiryDt());
		productQuanityDetailsDTO.setProductId(stockDetail.getProductId());
		productQuanityDetailsDTO.setProductMfgDt(stockDetail.getProductMfgDt());
		productQuanityDetailsDTO.setProductName(stockDetail.getProductName());
		productQuanityDetailsDTO.setProductQuantity(stockDetail.getProductQuantity());
		productQuanityDetailsDTO.setProductSellingPrice(stockDetail.getProductSellingPrice());
		productQuanityDetailsDTO.setProductSellVat(stockDetail.getProductSellVat());
		productQuanityDetailsDTO.setProductPurchasePrice(stockDetail.getProductPurchasePrice());
		productQuanityDetailsDTO.setProductPurchaseVat(stockDetail.getProductPurchaseVat());
		productQuanityDetailsDTO.setProductExtraInfo(stockDetail.getProductExtraInfo());
		productQuanityDetailsDTO.setProductLocation(stockDetail.getProductLocation());
		logger.debug("prepareStockDetailsObject :END");
		return productQuanityDetailsDTO;
	}
	public ResponseDTO validateAndSearchBathcNoDetails(String searchItemDetails) throws Exception{
		logger.debug("validateAndSearchBathcNoDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Criteria cri=session.createCriteria(TdProductQuanityDetail.class);
				cri.add(Restrictions.eq("productId",new BigInteger(searchItemDetails)));
				ProjectionList p1=Projections.projectionList();
		        p1.add(Projections.property("productBatchNo"));
		        cri.setProjection(p1);	
		        @SuppressWarnings("unchecked")
				List<String> batchnoList=cri.list();
				if(batchnoList.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(batchnoList);
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
		logger.debug("validateAndSearchBathcNoDetails :END");
		return responseDTO;
	}
	public ResponseDTO searchProductDetails(WildCardSearchBean productId) throws Exception{
		logger.debug("searchProdcuDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=new ArrayList<ProductQuanityDetailsDTO>();

		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdProductQuanityDetail> productDetails=session.createQuery("from TdProductQuanityDetail where productId = :searchString").setParameter("searchString",new BigInteger(productId.getSearchString())).list();
				if(null !=productDetails){
					if(productDetails.size()!=0){
						for(TdProductQuanityDetail productDetail:productDetails){
							ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
							productQuanityDetailsDTO=prepareStockDetailsObject(productDetail);
							ProductQuanityDetailsDTOList.add(productQuanityDetailsDTO);
						}
					}
				}
				responseDTO.setResponseObject(ProductQuanityDetailsDTOList);
				responseDTO.setStatus(Constants.SUCCESS);
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
		logger.debug("searchProdcuDetails :END");
		return responseDTO;
	}
	public ResponseDTO fetchAllStockDetails() throws Exception{
		logger.debug("fetchAllStockDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		List<ProductQuanityDetailsDTO> ProductQuanityDetailsDTOList=new ArrayList<ProductQuanityDetailsDTO>();

		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdProductQuanityDetail> productDetails=session.createQuery("from TdProductQuanityDetail").list();
				if(null !=productDetails){
					if(productDetails.size()!=0){
						for(TdProductQuanityDetail productDetail:productDetails){
							ProductQuanityDetailsDTO productQuanityDetailsDTO=new ProductQuanityDetailsDTO();
							productQuanityDetailsDTO=prepareStockDetailsObject(productDetail);
							ProductQuanityDetailsDTOList.add(productQuanityDetailsDTO);
						}
					}
				}
				responseDTO.setResponseObject(ProductQuanityDetailsDTOList);
				responseDTO.setStatus(Constants.SUCCESS);
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
		logger.debug("fetchAllStockDetails :END");
		return responseDTO;
	}
	@SuppressWarnings("unchecked")
	public List<TdProductQuanityDetail> fetchBillItem(ListOfProductQuanityDetailsDTO billItem) throws Exception{
		logger.debug("fetchBillItem :START");
		List<TdProductQuanityDetail> stockDetailsList=new ArrayList<TdProductQuanityDetail>();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				List<BigInteger> productIdsIn=new ArrayList<BigInteger>();
				for(NewBillProductDTO ids:billItem.getBillItems()){
						productIdsIn.add(new BigInteger(ids.getProductId()));
				}
				stockDetailsList=session.createQuery("from TdProductQuanityDetail where productId in :searchString").setParameterList("searchString", productIdsIn).list();
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
		logger.debug("fetchBillItem :END");
		return stockDetailsList;
	}
}
