package com.shopping.global.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.global.constants.Constants;
import com.shopping.global.dto.CustomerDueDetailsBean;
import com.shopping.global.dto.PrintCustomerDetails;
import com.shopping.global.model.TdCashTransaction;
import com.shopping.global.model.TdProfitLoss;
import com.shopping.global.util.DateUtil;

@Component
public class PrintUtilityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private DateUtil dateUtil;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<CustomerDueDetailsBean> fetchCustomerBetweenDate(PrintCustomerDetails printCustomerDetails) throws Exception{
		try
		{
			// create our mysql database connection
			//String myDriver = "com.mysql.jdbc.Driver";
			//String myUrl = "jdbc:mysql://localhost:3306/xlhxumrs_shopping";
			//Class.forName(myDriver);
			Connection con = null;
			SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor)this.getSessionFactory();
			ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
			try {
				con = connectionProvider.getConnection();
			}catch(Exception e){

			}
			String Date1="'"+printCustomerDetails.getStartDate()+" 00:00:00'";
			String Date2="'"+printCustomerDetails.getEndDate()+" 23:59:59'";
			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM td_customer_balance_details where (bill_date BETWEEN "+Date1 +"AND" +Date2+" AND customer_id="+ printCustomerDetails.getCustomerId()+")";

			// create the java statement
			Statement st = con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			List<CustomerDueDetailsBean> customerDues=new ArrayList<CustomerDueDetailsBean>();;
			while (rs.next())
			{

				CustomerDueDetailsBean customerDueDetailsBean=new CustomerDueDetailsBean();
				rs.getString("balance_details_code");
				customerDueDetailsBean.setBillAmount(new Double(rs.getDouble("bill_amount")).toString());
				customerDueDetailsBean.setBillDate(rs.getDate("bill_date").toString());
				customerDueDetailsBean.setBillNo(rs.getString("bill_no"));
				customerDueDetailsBean.setDueAmount(new Double( rs.getDouble("due_amount")).toString());
				customerDueDetailsBean.setPaidAmount(new Double(rs.getDouble("paid_amount")).toString());
				customerDues.add(customerDueDetailsBean);
			}
			st.close();
			return customerDues;
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			return null;
		}
	}
	public List<TdCashTransaction> fetchCustomerPayBetweenDate(PrintCustomerDetails printCustomerDetails) throws Exception{
		try
		{
			// create our mysql database connection
			Connection con = null;
			SessionFactoryImplementor sessionFactoryImplementation = (SessionFactoryImplementor)this.getSessionFactory();
			ConnectionProvider connectionProvider = sessionFactoryImplementation.getConnectionProvider();
			try {
				con = connectionProvider.getConnection();
			}catch(Exception e){

			}

			String Date1="'"+printCustomerDetails.getStartDate()+" 00:00:00'";
			String Date2="'"+printCustomerDetails.getEndDate()+" 23:59:59'";
			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM td_cash_transaction where (cash_record_date BETWEEN "+Date1 +"AND" +Date2+" AND customer_id="+ printCustomerDetails.getCustomerId()+")";

			// create the java statement
			Statement st = con.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			List<TdCashTransaction> customerPay=new ArrayList<TdCashTransaction>();
			while (rs.next())
			{
				TdCashTransaction tdCashTransaction=new TdCashTransaction();
				tdCashTransaction.setCashRecordId(new BigInteger(rs.getString("cash_record_id")));
				tdCashTransaction.setAmount(rs.getDouble("amount"));
				tdCashTransaction.setCashRecordDate(rs.getDate("cash_record_date"));
				tdCashTransaction.setPaymentType(rs.getString("paymentType"));
				customerPay.add(tdCashTransaction);
			}
			st.close();
			return customerPay;
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			return null;
		}
	}

	public List<TdProfitLoss> fetchProfitBetweenDates(String sDate,String eDate) throws Exception{
		try {
			Session session=this.getSessionFactory().openSession();
			Transaction tx=session.getTransaction();
			try {
				tx.begin();
				//Criteria cr = session.createCriteria(TdProfitLoss.class);
				Date date=dateUtil.stringToDate(sDate, Constants.DATE_FORMAT_STOCK);
				Date date1=dateUtil.stringToDate(eDate, Constants.DATE_FORMAT_STOCK);

//				cr.add(Restrictions.ge("day", date));
//				cr.add(Restrictions.lt("day", date1));
//				cr .setProjection(Projections.projectionList().add(Projections.sqlGroupProjection("date(day) as createdDate", "createdDate", new String[] { "createdDate" }, new Type[] { StandardBasicTypes.DATE })));
//				cr.setProjection((Projections.sum("amount")));



				ProjectionList projList = Projections.projectionList();
				projList.add(Projections.sum("tr.amount").as("amount"));
				projList.add(Projections.sqlGroupProjection("date(day) as createdDate", "createdDate", new String[] { "createdDate" }, new Type[] { StandardBasicTypes.DATE }));

			//	projList.add(Projections.property("firstName"));
				//projList.add(Projections.property("lastName"));
				//add other fields you need in the projection list

				Criteria criteria = session.createCriteria(TdProfitLoss.class, "tr")
				               // .createAlias("tr.day", "day")
				               // .createAlias("tr.amount", "amount")
				                .add(Restrictions.ge("day", date))
				                .add(Restrictions.lt("day", date1))
				                .setProjection(projList);






				List<Object> result = (List<Object>)criteria.list();
				Iterator itr = result.iterator();
				List<TdProfitLoss> dto=new ArrayList<TdProfitLoss>();
				while(itr.hasNext()){
				   Object[] obj = (Object[]) itr.next();
				   Double amount = Double.parseDouble(String.valueOf(obj[0]));
				   Date Date = dateUtil.stringToDate(String.valueOf(obj[1]), Constants.DATE_FORMAT_STOCK) ;
				   TdProfitLoss tdprofitDto=new TdProfitLoss();
				   tdprofitDto.setAmount(amount);
				   tdprofitDto.setDay(Date);
				   dto.add(tdprofitDto);

				}

				return dto;
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
}
