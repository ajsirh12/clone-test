package com.thereal.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.thereal.dao.AdminDAO;
import com.thereal.service.AdminViewService;

@Service("adminViewService")
public class AdminViewServiceImpl implements AdminViewService{

	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	private static final String redirect_main = "redirect:/admin/main";
	private static final String redirect_login = "redirect:/admin/login";
	
	@Autowired AdminDAO adminDAO;
	@Autowired LoginServiceImpl loginService;

	@Override
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session) {
		if(loginService.isLogin(session)) {
			return new ModelAndView(redirect_main);
		}
		return new ModelAndView("home/login");
	}

	@Override
	public ModelAndView getMain(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/main");
	}

	@Override
	public ModelAndView getTemplate(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/template");
	}

	@Override
	public ModelAndView getStatistic(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/statistic");
	}
	
	@Override
	public ModelAndView getRegist(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/regist");
	}
}
