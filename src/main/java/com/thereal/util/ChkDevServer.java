package com.thereal.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 개발서버 확인 <br><br>
 * 
 * boolean isDev() : 개발서버 여부 확인<br>
 * String getIpAddress() : ip주소 확인
 * 
 * @author LimDK
 * 
 */
public class ChkDevServer {

	private static final String LOCAL_HOST = "127.0.0.1";
	private static final String IP_TIME = "192.168.0.";
	
	private static boolean isDev;
	
	private static final Logger logger = LogManager.getLogger(ChkDevServer.class);
	
	private static String serverIP = "";
	
	private ChkDevServer() {
		isDev = setDevServer();
		logger.info(getIpAddress());
	}
	
	private static class LazyHolder {
		private static final ChkDevServer SINGLETON = new ChkDevServer(); 
	}
	
	/**
	 * singleton pattern <br>
	 * LazyHolder
	 * @return
	 */
	public static ChkDevServer getInstance() {
		return LazyHolder.SINGLETON;
	}
	
	private boolean setDevServer() {
		boolean flag = false;
		
		InetAddress Address;
		String IP;
		
		try {
			Address = InetAddress.getLocalHost();
			IP = Address.getHostAddress();
			
			serverIP = IP;
			
			if(IP.equals(LOCAL_HOST)) {
				flag = true;
			}
			else if(IP.startsWith(IP_TIME)) {
				flag = true;
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 개발서버 확인
	 * @return boolean
	 */
	public boolean isDev() {
		return isDev;
	}
	
	/**
	 * ip주소 확인
	 * @return serverIP
	 */
	public String getIpAddress() {
		String result = "";
		
		if(isDev) {
			result = "This server is devServer " + serverIP;
		}
		else {
			result = "Server Ip is " + serverIP;
		}
		
		return result;
	}
}
