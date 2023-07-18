package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.thereal.model.vo.RegistVO;

public interface RegistService {
	ResponseEntity ajaxRegist(RegistVO vo, HttpSession session);
	
	ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session);
	ResponseEntity ajaxPhones(HttpServletRequest request, HttpSession session);
	ResponseEntity ajaxButtons(HttpServletRequest request, HttpSession session);
	
	ResponseEntity ajaxTemplates(HttpServletRequest request, HttpSession session);
}
