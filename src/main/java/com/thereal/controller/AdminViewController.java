package com.thereal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thereal.serviceimpl.AdminViewServiceImpl;

@Controller
@RequestMapping(value = "/admin")
public class AdminViewController {
	
	private static final Logger logger = LogManager.getLogger(AdminViewController.class);
	
	@Autowired AdminViewServiceImpl adminViewService;
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getMain ==========");
		return new ModelAndView("redirect:/main");
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getLogin ==========");
		return adminViewService.getLogin(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView getMain(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getMain ==========");
		return adminViewService.getMain(request, session);
	}

	@ResponseBody
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public ModelAndView getTemplate(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getTemplate ==========");
		return adminViewService.getTemplate(request, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	public ModelAndView getStatistic(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getStatistic ==========");
		return adminViewService.getStatistic(request, session);
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public ModelAndView getRegist(HttpServletRequest request, HttpSession session) {
		logger.debug("========== getRegist ==========");
		return adminViewService.getRegist(request, session);
	}
}
