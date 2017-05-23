package com.shopping.global.util;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Component("encryptDecrypt")
public class EncryptDecrypt {
	 private static final String ALGO = "AES";
	    private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B',
	            'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	    public  String encrypt(String Data) {
	    	String encryptedValue = null;
	    	try{
	    		Key key = generateKey();
	    		Cipher c = Cipher.getInstance(ALGO);
	    		c.init(Cipher.ENCRYPT_MODE, key);
	    		byte[] encVal = c.doFinal(Data.getBytes());
	    		 encryptedValue = new BASE64Encoder().encode(encVal);
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return encryptedValue;
	    }

	    public  String decrypt(String encryptedData)  {
	    	String decryptedValue =null;
	    	try{
	    		Key key = generateKey();
	    		Cipher c = Cipher.getInstance(ALGO);
	    		c.init(Cipher.DECRYPT_MODE, key);
	    		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
	    		byte[] decValue = c.doFinal(decordedValue);
	    		decryptedValue = new String(decValue);
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return decryptedValue;
	    }

	    private static Key generateKey() throws Exception {
	        Key key = new SecretKeySpec(keyValue, ALGO);
	        return key;
	    }

}
