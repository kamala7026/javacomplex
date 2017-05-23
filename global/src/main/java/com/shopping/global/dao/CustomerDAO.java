package com.shopping.global.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.constants.Constants;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.model.TdCashTransaction;
import com.shopping.global.model.TdCustomerBalance;
import com.shopping.global.model.TdCustomerBalanceDetail;
import com.shopping.global.model.TdCustomerDetail;
import com.shopping.global.model.TdCustomerSearch;
import com.shopping.global.services.ResponseDTO;


@Component
public class CustomerDAO {

	final static Logger logger = LoggerFactory.getLogger(CustomerDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ResponseDTO searchCustomerDetails(WildCardSearchBean customerSearch) throws Exception{
		logger.debug("searchCustomerDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerSearch> customerSearchDetailsList=session.createQuery("from TdCustomerSearch where customerId like :SearchString OR godownNo like :SearchString OR name like:SearchString OR mobile like :SearchString").setParameter("SearchString", "%"+customerSearch.getSearchString()+"%").list();
				if(customerSearchDetailsList.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerSearchDetailsList);
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
		logger.debug("searchCustomerDetails :END");
		return responseDTO;
	}
	public ResponseDTO saveCustomerDetails(TdCustomerDetail customerDetails) throws Exception{
		logger.debug("saveCustomerDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				session.save(customerDetails);
				tx.commit();
				responseDTO.setMessage(customerDetails.getCustomerId().toString());
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
		logger.debug("saveCustomerDetails :END");
		return responseDTO;
	}
	public ResponseDTO searchCustomerDues(WildCardSearchBean customerSearch) throws Exception{
		logger.debug("searchCustomerDues :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerBalance> customerDues=session.createQuery("from TdCustomerBalance where customerId = :searchString").setParameter("searchString",new BigInteger(customerSearch.getSearchString())).list();
				if(customerDues.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerDues);
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
		logger.debug("searchCustomerDues :END");
		return responseDTO;
	}
	public ResponseDTO searchCustomerDueDetails(WildCardSearchBean customerSearch) throws Exception{
		logger.debug("searchCustomerDueDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerBalanceDetail> customerDues=session.createQuery("from TdCustomerBalanceDetail  where customerId = :searchString").setParameter("searchString",new BigInteger(customerSearch.getSearchString())).list();
				if(customerDues.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerDues);
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
		logger.debug("searchCustomerDueDetails :END");
		return responseDTO;
	}
	public ResponseDTO searchCustomerPaymentDetails(WildCardSearchBean customerSearch) throws Exception{
		logger.debug("searchCustomerPaymentDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCashTransaction> customerDues=session.createQuery("from TdCashTransaction  where customerId = :searchString").setParameter("searchString",new BigInteger(customerSearch.getSearchString())).list();
				if(customerDues.size()!=0){
					responseDTO.setStatus(Constants.SUCCESS);
					responseDTO.setResponseObject(customerDues);
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
		logger.debug("searchCustomerPaymentDetails :END");
		return responseDTO;
	}
	public List<CustomerSearchDTO> fetchAllCustomers() throws Exception{
		logger.debug("fetchAllCustomers :START");
		List<CustomerSearchDTO> listofCustomers=new ArrayList<CustomerSearchDTO>();
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				@SuppressWarnings("unchecked")
				List<TdCustomerSearch> customerSearchDetailsList=session.createQuery("from TdCustomerSearch").list();
				if(customerSearchDetailsList.size()!=0){
					for(TdCustomerSearch customerData:customerSearchDetailsList){
						CustomerSearchDTO customerSearchDTO=new CustomerSearchDTO();
						listofCustomers.add(prepareCustomerAllDetailsObject(customerSearchDTO,customerData));

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
		logger.debug("fetchAllCustomers :END");
		return listofCustomers;
	}
	private CustomerSearchDTO prepareCustomerAllDetailsObject(CustomerSearchDTO customerSearchDTO,TdCustomerSearch customerDataFromDB){
		logger.debug("prepareCustomerAllDetailsObject :START");
		customerSearchDTO.setCustomerId(customerDataFromDB.getCustomerId());
		customerSearchDTO.setGodownNo(customerDataFromDB.getGodownNo());
		customerSearchDTO.setMobile(customerDataFromDB.getMobile());
		customerSearchDTO.setName(customerDataFromDB.getName());
		logger.debug("prepareCustomerAllDetailsObject :END");
		return customerSearchDTO;
	}
	
}
