package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

public interface RegistService {
	ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session);
	ResponseEntity ajaxPhones(HttpServletRequest request, HttpSession session);
	ResponseEntity ajaxButtons(HttpServletRequest request, HttpSession session);
}
