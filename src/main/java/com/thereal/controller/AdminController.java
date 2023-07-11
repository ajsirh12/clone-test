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
import org.springframework.web.bind.annotation.ResponseBody;

import com.thereal.model.vo.ChannelVO;
import com.thereal.model.vo.PhoneVO;
import com.thereal.model.vo.TemplateVO;
import com.thereal.serviceimpl.AdminServiceImpl;

@Controller
@RequestMapping(value = "/api/v1")
public class AdminController {
	private static final Logger logger = LogManager.getLogger(AdminController.class);
	
	@Autowired AdminServiceImpl adminService;

	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ResponseEntity postLogin(HttpServletRequest request, HttpSession session) {
		logger.debug("========== postLogin ==========");
		return adminService.postLogin(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/phone.do", method = RequestMethod.GET)
	public ResponseEntity getPhoneList(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getPhoneList ==========");
		return adminService.getPhoneList(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/phone.do", method = RequestMethod.POST)
	public ResponseEntity postPhoneList(HttpServletRequest request, HttpSession session, @RequestBody PhoneVO vo) {
		logger.debug("========== postPhoneList ==========");
		return adminService.postPhoneList(request, session, vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/channel.do", method = RequestMethod.GET)
	public ResponseEntity getChannelList(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getChannelList ==========");
		return adminService.getChannelList(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/channel.do", method = RequestMethod.POST)
	public ResponseEntity postChannelList(HttpServletRequest request, HttpSession session, @RequestBody ChannelVO vo) {
		logger.debug("========== postPhoneList ==========");
		return adminService.postChannelList(request, session, vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/template.do", method = RequestMethod.GET)
	public ResponseEntity getTemplateList(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getTemplateList ==========");
		return adminService.getTemplateList(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/template.do", method = RequestMethod.POST)
	public ResponseEntity postTemplateList(HttpServletRequest request, HttpSession session, @RequestBody TemplateVO vo) {
		logger.debug("========== postTemplateList ==========");
		return adminService.postTemplateList(request, session, vo);
	}
}
