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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thereal.serviceimpl.StatServiceImpl;

@Controller
@RequestMapping(value = "/api/v1/statistics")
public class StatController {
	
	private static final Logger logger = LogManager.getLogger(StatController.class);
	
	@Autowired StatServiceImpl statService;
	
	@ResponseBody
	@RequestMapping(value = "/total.do", method = RequestMethod.GET)
	public ResponseEntity getCountStatus(HttpServletRequest request, HttpSession session) {
		return statService.selectCountStatics(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/sub-list.do", method = RequestMethod.GET)
	public ResponseEntity getSubList(HttpServletRequest request, HttpSession session) {
		return statService.selectSubList(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/stat.do", method = RequestMethod.GET)
	public ResponseEntity getCountStat(HttpServletRequest request, HttpSession session, @RequestParam String param) {
		return statService.selectCountStat(request, session, param);
	}
}
