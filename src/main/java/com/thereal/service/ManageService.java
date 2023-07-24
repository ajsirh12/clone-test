package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

public interface ManageService {
	ResponseEntity getTemplateList(HttpServletRequest request, HttpSession session);
	ResponseEntity getTemplateDetail(HttpServletRequest request, HttpSession session);
}
