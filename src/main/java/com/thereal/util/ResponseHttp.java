package com.thereal.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ResponseHttp {
	
	private static HttpHeaders httpHeader = null;
	
	private static void init() {
		httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
	}
	
	public static ResponseEntity ok(Map<String, Object> resMessage) {
		return base(resMessage, HttpStatus.OK);
	}
	
	public static ResponseEntity failed(Map<String, Object> resMessage) {
		return base(resMessage, HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity status(Map<String, Object> resMessage, HttpStatus httpStatus) {
		return base(resMessage, httpStatus);
	}
	
	private static ResponseEntity base(Map<String, Object> resMessage, HttpStatus httpStatus) {
		if(httpHeader == null) {
			init();
		}
		if(resMessage == null) {
			resMessage = new HashMap<String, Object>();
		}
		resMessage.put("status", httpStatus.value());
		resMessage.put("timestamp", timeStamp());
		return new ResponseEntity(resMessage, httpHeader, httpStatus);
	}
	
	private static String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
}
