package com.thereal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thereal.serviceimpl.ManageServiceImpl;

@Controller
@RequestMapping(value = "/ajax/manage")
public class ManageController {
	
	private static final Logger logger = LogManager.getLogger(ManageController.class);
	
	@Autowired ManageServiceImpl manageService;
	
	@RequestMapping(value = "/template/list", method = RequestMethod.POST)
	public ResponseEntity getTemplateList(HttpServletRequest request, HttpSession session) {
		return manageService.getTemplateList(request, session);
	}
	
	@RequestMapping(value = "/template/detail", method = RequestMethod.POST)
	public ResponseEntity getTemplateDetail(HttpServletRequest request, HttpSession session) {
		return manageService.getTemplateDetail(request, session);
	}
}
