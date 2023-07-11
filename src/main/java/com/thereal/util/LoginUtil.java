package com.thereal.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;

public class LoginUtil {
	
	public static boolean doLogin(String name, String pwd, String enc) {
		String key = name + ":" + pwd;
		byte[] buffer = key.getBytes();
		Encoder encoder = Base64.getMimeEncoder();
		
		if(enc.equals(encoder.encodeToString(buffer))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isLogin(HttpSession session) {
		Object key01 = session.getAttribute("key01");
		Object key02 = session.getAttribute("key02");
		
		if(key01 == null || key02 == null) {
			return false;	
		}
		else {
			session.setMaxInactiveInterval(900);
			return true;
		}
	}
	
	public static String getHash(String name) {
		String hash = "";
		
		Mac hmacSHA256;
		try {
			hmacSHA256 = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKey = new SecretKeySpec((name + getDate()).getBytes(), "HmacSHA256");
			hmacSHA256.init(secretKey);
			
			hash = org.apache.commons.codec.binary.Base64.encodeBase64String(hmacSHA256.doFinal(name.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return hash;
	}
	
	private static String getDate() {
		String result = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		result = sdf.format(date);

		return result;
	}
}
