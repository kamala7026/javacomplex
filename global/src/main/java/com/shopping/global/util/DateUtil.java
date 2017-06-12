package com.shopping.global.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class DateUtil {

	final static Logger logger = LoggerFactory.getLogger(DateUtil.class);
	
	public String dateToString(Date date){
		if(date==null){
			return "";
		}
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");  
		String text = df.format(date);
		return text; 
	}
	public  Date stringToDate(String date,String format)
	{
		logger.debug("stringToDate :START");
		try{
			if(null == date){
				return null;
			}else{
				if(! date.equalsIgnoreCase("")){
					SimpleDateFormat formatter = new SimpleDateFormat(format);
				    return formatter.parse(date);
				}
			}
			
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		logger.debug("stringToDate :END");
		return null;
	}
	public  Date dateToDate(Date date,String format)
	{
		logger.debug("stringToDate :START");
		try{
			if(null == date){
				return null;
			}
			else{
				SimpleDateFormat formatter = new SimpleDateFormat(format);
			    return formatter.parse(date.toString());
			}
			
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		logger.debug("stringToDate :END");
		return null;
	}
	public static String dateFormatChange(String date) throws ParseException
	{
		logger.debug("dateFormatChange :START");
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date1=formatter.parse(date);
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
	    logger.debug("dateFormatChange :END");
	    return formatter1.format(date1);
	}
//	public static int noOfDayBetweenTwoDate(String startDate,String endDate) throws ParseException{
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
//		Date date=formatter.parse(startDate);
//		Date date1=formatter.parse(endDate);
//		LocalDate start = new LocalDate(date.getTime());
//	    LocalDate end = new LocalDate(date1.getTime()).plusDays(1);
//	    int days = Days.daysBetween(start, end).getDays();
//		return days;
//	    
//	}
}
