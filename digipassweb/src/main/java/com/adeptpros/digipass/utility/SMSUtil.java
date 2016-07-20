package com.adeptpros.digipass.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

public class SMSUtil { 
	 // Find your Account Sid and Token at twilio.com/user/account 
	 public static final String ACCOUNT_SID = "ACced9d9daffe5794eb097179adc80482c"; 
	 public static final String AUTH_TOKEN = "f12d8af6dfa7d8d27fb24adf8e6ac165"; 
	 
	 public static String sendSMS(String toNumber,String body) throws Exception{
		 String status="";
		 Message message=null;
		 try {
			 TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 		 
			 // Build the parameters 
			 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
			 params.add(new BasicNameValuePair("To",toNumber)); 
			 params.add(new BasicNameValuePair("From", "++13203210899")); 
			 params.add(new BasicNameValuePair("Body", body)); 
			// params.add(new BasicNameValuePair("MessagingServiceSid", "MG6540d3652e55069aab00ca402a56bb63"));
			 //params.add(new BasicNameValuePair("MediaUrl", "https://demo.twilio.com/Accounts/ACc8375e928fce7b7294a5c18bbea75914/SMS/Messages"));  
		 
			 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
			 message = messageFactory.create(params); 
			 System.out.println(message.getSid());
			 if(!message.getStatus().equals("failed") || !message.equals("undelivered")){
				 status="success";
				 System.out.println("message status for mobile number "+toNumber+ " === "+message.getStatus());
			 }else{
				 System.out.println("message status for mobile number "+toNumber+ " === "+message.getStatus());
				 status=message.getStatus();
			 }
			 
		} catch (Exception e) {
			System.out.println("message status for mobile number "+toNumber+ " === "+message.getStatus());
			e.printStackTrace();
			status="error";
			throw e;
		}
		return status;
		  
	 }
	 
	 public static void main(String[]args) throws Exception { 
		 sendSMS("+917204856289", "hello kamalakanta");
		/*TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	 
		 // Build the parameters 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("To", "+919901446088")); 
		 params.add(new BasicNameValuePair("From", "+12567403929")); 
		 params.add(new BasicNameValuePair("Body", "hello kamalakanta behera")); 
		// params.add(new BasicNameValuePair("MessagingServiceSid", "MG6540d3652e55069aab00ca402a56bb63"));
		//params.add(new BasicNameValuePair("MediaUrl", "https://demo.twilio.com/Accounts/ACc8375e928fce7b7294a5c18bbea75914/SMS/Messages"));  
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); */
	 }
}

