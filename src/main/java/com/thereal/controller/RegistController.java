package com.thereal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thereal.model.vo.RegistSubVO;
import com.thereal.model.vo.RegistVO;
import com.thereal.serviceimpl.RegistServiceImpl;

@Controller
public class RegistController {
	private static final Logger logger = LogManager.getLogger(RegistController.class);
	
	@Autowired
	private RegistServiceImpl registService;
	
	@RequestMapping(value = "/ajax/regist", method = RequestMethod.POST)
	public ResponseEntity ajaxRegist(@RequestBody RegistVO vo, HttpSession session) {
		logger.debug(vo.toString());
		return registService.ajaxRegist(vo, session);
	}
	
	@RequestMapping(value = "/ajax/channels", method = RequestMethod.POST)
	public ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session) {
		return registService.ajaxChannels(request, session);
	}
	
	@RequestMapping(value = "/ajax/phones", method = RequestMethod.POST)
	public ResponseEntity ajaxPhones(HttpServletRequest request, HttpSession session) {
		return registService.ajaxPhones(request, session);
	}
	
	@RequestMapping(value = "/ajax/buttons", method = RequestMethod.POST)
	public ResponseEntity ajaxButtons(HttpServletRequest request, HttpSession session) {
		return registService.ajaxButtons(request, session);
	}
	
	@RequestMapping(value = "/ajax/templates", method = RequestMethod.POST)
	public ResponseEntity ajaxTemplates(HttpServletRequest request, HttpSession session) {
		return registService.ajaxTemplates(request, session);
	}
	
	@RequestMapping(value = "/ajax/check/sub", method = RequestMethod.POST)
	public ResponseEntity ajaxCheckSub(HttpServletRequest request, HttpSession session) {
		return registService.ajaxCheckSub(request, session);
	}
	
	@RequestMapping(value = "/ajax/regist/sub", method = RequestMethod.POST)
	public ResponseEntity ajaxRegistSub(@RequestBody RegistSubVO vo, HttpSession session) {
		return registService.ajaxRegistSub(vo, session);
	}
	
	@RequestMapping(value = "/ajax/check/templates", method = RequestMethod.POST)
	public ResponseEntity ajaxCheckTemp(HttpServletRequest request, HttpSession session) {
		return registService.ajaxCheckTemp(request, session);
	}
}
