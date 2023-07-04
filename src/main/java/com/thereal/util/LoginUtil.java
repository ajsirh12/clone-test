package com.thereal.util;

import java.util.Base64;
import java.util.Base64.Encoder;

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
}
