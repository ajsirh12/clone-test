package com.thereal.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.thereal.dao.AdminDAO;
import com.thereal.service.AdminViewService;
import com.thereal.util.LoginUtil;

@Service("adminViewService")
public class AdminViewServiceImpl implements AdminViewService{

	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	private static final String redirect_main = "redirect:/main";
	private static final String redirect_login = "redirect:/login";
	@Autowired AdminDAO adminDAO;

	@Override
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session) {
		if(LoginUtil.isLogin(session)) {
			return new ModelAndView(redirect_main);
		}
		return new ModelAndView("home/login");
	}

	@Override
	public ModelAndView getMain(HttpServletRequest request, HttpSession session) {
		if(!LoginUtil.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/main");
	}

	@Override
	public ModelAndView getTemplate(HttpServletRequest request, HttpSession session) {
		if(!LoginUtil.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/template");
	}

	@Override
	public ModelAndView getStatistic(HttpServletRequest request, HttpSession session) {
		if(!LoginUtil.isLogin(session)) {
			return new ModelAndView(redirect_login);
		}
		return new ModelAndView("home/statistic");
	}
}
