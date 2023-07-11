package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

public interface RegistService {
	ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session);
}
