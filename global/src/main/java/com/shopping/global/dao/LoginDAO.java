package com.shopping.global.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.dto.LoginDTO;
import com.shopping.global.dto.SignUpDTO;
import com.shopping.global.exception.PasswordIncorrectException;
import com.shopping.global.model.TdUserLogin;


@Component
public class LoginDAO {

	final static Logger logger = LoggerFactory.getLogger(LoginDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public LoginDTO userAuth(LoginDTO loginDTO) throws Exception{
		logger.debug("userAuth :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				TdUserLogin tuser=(TdUserLogin) session.get(TdUserLogin.class, loginDTO.getUserName());
				if(tuser.getPassword().equalsIgnoreCase(loginDTO.getPassword())){
					loginDTO.setName(tuser.getUserName());
					loginDTO.setShopId(tuser.getShopId());
					loginDTO.setStatus(tuser.getStatus());
					loginDTO.setUserId(tuser.getUserId().toString());
					loginDTO.setUserName(tuser.getUserName());
					loginDTO.setUserRole(tuser.getUserRole());
				}else{
					throw new PasswordIncorrectException();
				}
			}catch (PasswordIncorrectException e) {
				tx.rollback();
				throw e;
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
			
		} catch (Exception e) {
			throw e;
		}
		logger.debug("userAuth :END");
		return loginDTO;
	}
	public int changePassword(String userName,String password) throws Exception{
		logger.debug("changePassword :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				String hql = "UPDATE TdUserLogin set password = :password "  + 
			             "WHERE userName = :userName";
			Query query = session.createQuery(hql);
			query.setParameter("password", password);
			query.setParameter("userName", userName);
			int rows= query.executeUpdate();
			tx.commit();
			return rows;
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
			
		} catch (Exception e) {
			throw e;
		}
	}
	public Boolean forgotPswd(String email,String userName){
		logger.debug("userAuth :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				TdUserLogin tuser=(TdUserLogin) session.get(TdUserLogin.class, userName);
				if(null !=tuser){
					return email.equalsIgnoreCase(tuser.getEmail()) ? true :false;
				}
				
			}
			catch (Exception e) {
				tx.rollback();
				logger.debug(e.getMessage());
			}finally{
				try {					
					session.close();
				} catch (Exception e2) {
					tx.rollback();
					logger.debug(e2.getMessage());
				}
			}
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		logger.debug("userAuth :END");
		return false;
	}
	
	
	public Boolean signUp(SignUpDTO signUpData) throws Exception{
		logger.debug("signUp :START");
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			TdUserLogin tdUserLogin=new TdUserLogin();
			tdUserLogin.setEmail(signUpData.getEmail());
			tdUserLogin.setPassword(signUpData.getPassword());
			tdUserLogin.setShopId(signUpData.getShopId());
			tdUserLogin.setStatus(signUpData.getStatus());
			tdUserLogin.setUserName(signUpData.getUserName());
			tdUserLogin.setUserRole(signUpData.getUserRole());
			try {
				tx.begin();
				session.save(tdUserLogin);
				tx.commit();
				if(null != tdUserLogin.getUserId()){
					return true;
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
			
		} catch (Exception e) {
			throw e;
		}
		logger.debug("signUp :END");
		return false;
	}
}
