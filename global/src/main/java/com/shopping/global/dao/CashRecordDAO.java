package com.shopping.global.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.constants.Constants;
import com.shopping.global.exception.UnknownDbError;
import com.shopping.global.model.TdCashTransaction;
import com.shopping.global.model.TdCustomerBalance;
import com.shopping.global.services.ResponseDTO;


@Component
public class CashRecordDAO {

	final static Logger logger = LoggerFactory.getLogger(CashRecordDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public ResponseDTO saveCashRecord(TdCashTransaction tdCashTransaction) throws Exception{
		logger.debug("saveCustomerDetails :START");
		ResponseDTO responseDTO=new ResponseDTO();
		Boolean customerTotalDueStatus=false;
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				session.save(tdCashTransaction);
				tx.commit();
				
				if(StringUtils.isNotBlank(tdCashTransaction.getCashRecordId().toString())){
				 customerTotalDueStatus=updateCustomerTotalDue(tdCashTransaction);
				 
				}
				if(customerTotalDueStatus){
					responseDTO.setMessage(tdCashTransaction.getCashRecordId().toString());
					responseDTO.setStatus(Constants.SUCCESS);
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
		logger.debug("saveCustomerDetails :END");
		return responseDTO;
	}
	private Boolean updateCustomerTotalDue(TdCashTransaction tdCashTransaction){
		logger.debug("updateCustomerTotalDue :START");
		Boolean customerTotalDueStatus=false;
		if(StringUtils.isNotBlank(tdCashTransaction.getCustomerId().toString())){
			try {
				Session session=this.getSessionFactory().openSession();
				Transaction tx=session.getTransaction();
				try {
					tx.begin();
					Object o=session.get(TdCustomerBalance.class,tdCashTransaction.getCustomerId());
					if(null != o){
						TdCustomerBalance tdCustomerBalance=(TdCustomerBalance)o;
						Double dbQuanity=tdCustomerBalance.getTotalBalance();
						Double val= dbQuanity-tdCashTransaction.getAmount();
						tdCustomerBalance.setTotalBalance(val);
						tx.commit();
						customerTotalDueStatus=true;
					}
					else{
						TdCustomerBalance tdCustomerBalance=new TdCustomerBalance();
						tdCustomerBalance.setCustomerId(tdCashTransaction.getCustomerId());
						tdCustomerBalance.setGodownno(tdCashTransaction.getGoddownNo());
						tdCustomerBalance.setName(tdCashTransaction.getName());
						tdCustomerBalance.setTotalBalance(-tdCashTransaction.getAmount());
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
}
