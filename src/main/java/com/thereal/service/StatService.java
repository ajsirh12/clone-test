package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

public interface StatService {
	public ResponseEntity selectTotal(HttpServletRequest request, HttpSession session);
	
	public ResponseEntity selectCountStatics(HttpServletRequest request, HttpSession session);
	public ResponseEntity selectSubList(HttpServletRequest request, HttpSession session);
	public ResponseEntity selectCountStat(HttpServletRequest request, HttpSession session, String param);
}
