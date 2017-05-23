package com.shopping.global.util;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.dto.LoginDTO;
import com.shopping.global.model.TdUserLog;

@Component
public class LogUserDetailsUtil {

	final static Logger logger = LoggerFactory.getLogger(LogUserDetailsUtil.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BigInteger LoguserData(LoginDTO login){
		logger.debug("LoguserData :START");
		try {
			TdUserLog tdUserLog=new TdUserLog();
			tdUserLog.setIpAddress(login.getClientIp());
			tdUserLog.setLogginDate(new Timestamp(new Date().getTime()));
			tdUserLog.setSessionId(login.getSessionId());
			tdUserLog.setShopId(login.getShopId());
			tdUserLog.setUserId(login.getUserId());
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				session.save(tdUserLog);
				tx.commit();
				logger.debug("LoguserData :END");
				logger.debug("User Track Id-",tdUserLog.getUser_track_id());
				return tdUserLog.getUser_track_id();
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

	public void updateInActiveUser(BigInteger userTrackId){
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				Object o=session.get(TdUserLog.class,userTrackId);
				if(null != o){
					TdUserLog TtdUserLog=(TdUserLog)o;
					TtdUserLog.setLoggedOutDate(new Timestamp(new Date().getTime()));
					tx.commit();
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
	}
}
