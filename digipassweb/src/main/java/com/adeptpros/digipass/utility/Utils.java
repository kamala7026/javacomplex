package com.adeptpros.digipass.utility;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {
	public static final String SERVER_URL="http://apps.scaits.in";
	public static String getTimeStamp(){
		GregorianCalendar calendar=(GregorianCalendar) GregorianCalendar.getInstance();
		return calendar.get(Calendar.DATE)+"-"+calendar.get(Calendar.HOUR)+"-"+calendar.get(Calendar.MINUTE)+"-"+calendar.get(Calendar.SECOND);
	}
	public static Date getStringToDate(String dateInString) throws ParseException{
		Date date=null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}
		return date;
	}
	
	public static float getDaysBetweenTwoDates(String inputString1,String inputString2) throws ParseException{
		float days=0;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
		    Date date1 = myFormat.parse(inputString1);
		    Date date2 = myFormat.parse(inputString2);
		    long diff = date2.getTime() - date1.getTime();
		    days=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
		    e.printStackTrace();
		    throw e;
		}
		return days;
	}
	public static Timestamp getStringToTimeStamp(String timeStampString) throws ParseException{
		System.out.println(timeStampString+"  jhjhjh");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyhh:mm:a");
		    Date parsedDate = dateFormat.parse(timeStampString);
		    Timestamp timestamp = new Timestamp(parsedDate.getTime());
		    return timestamp;
	}
	
	public static Timestamp getStringToTimeStamp1(String timeStampString) throws ParseException{
		System.out.println(timeStampString+"  jhjhjh");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		    Date parsedDate = dateFormat.parse(timeStampString);
		    Timestamp timestamp = new Timestamp(parsedDate.getTime());
		    return timestamp;
	}
	
	public static long getHoursBetweenTwoTimeStamps(String dateStart,String dateStop){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start="+dateStart);
        System.out.println("end="+dateStop);
        long diffHours=0;
        Date d1 = null;
        Date d2 = null;

        try {
                d1 = format.parse(dateStart);
                d2 = format.parse(dateStop);

                //in milliseconds
                long diff = d2.getTime() - d1.getTime();

                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                diffHours = diff / (60 * 60 * 1000);// % 24;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return diffHours;
}
	public static int compareTimeStamp(Timestamp t1, Timestamp t2) {

	    long l1 = t1.getTime();
	    long l2 = t2.getTime();
	    if (l2 > l1)
	    return 1;
	    else if (l1 > l2)
	    return -1;
	    else
	    return 0;
	}
	public static String getStringFromTimeStamp(Timestamp t){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		return dateFormat.format(t);
	}
	public static Date getDateFromTimeStamp(Timestamp t){		  
		  Date date = new Date(t.getTime());
		return date;
	}
	public static int randInt() {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((1000000 - 6) + 6) + 100000;
	    return randomNum;
	}
	 static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	 public static String randomString( ){
		   int len=8; 
		   SecureRandom rnd = new SecureRandom();
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		}
	public static void main(String[] args) {
		System.out.println(randomString());

		
	}
	public static String getStringFromTimeStamp1(Timestamp t) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm a");
		return dateFormat.format(t);
	}
}
