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

import com.thereal.serviceimpl.RegistServiceImpl;

@Controller
public class RegistController {
	private static final Logger logger = LogManager.getLogger(RegistController.class);
	
	@Autowired
	private RegistServiceImpl registService;
	
	@RequestMapping(value = "/ajax/channels", method = RequestMethod.POST)
	public ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session) {
		return registService.ajaxChannels(request, session);
	}
}
