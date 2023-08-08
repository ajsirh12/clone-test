package com.thereal.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.thereal.constant.PageView;
import com.thereal.constant.Redirect;
import com.thereal.dao.AdminDAO;
import com.thereal.service.AdminViewService;

@Service("adminViewService")
public class AdminViewServiceImpl implements AdminViewService{

	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	
	@Autowired AdminDAO adminDAO;
	@Autowired LoginServiceImpl loginService;

	@Override
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session) {
		if(loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_MAIN.getValue());
		}
		return new ModelAndView(PageView.HOME_LOGIN.getValue());
	}

	@Override
	public ModelAndView getMain(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_MAIN.getValue());
	}

	@Override
	public ModelAndView getTemplate(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_TEMPLATE.getValue());
	}

	@Override
	public ModelAndView getStatistic(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_STATISTIC.getValue());
	}
	
	@Override
	public ModelAndView getRegist(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_REGIST.getValue());
	}
	
	@Override
	public ModelAndView getRegistSub(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_SUB_REGIST.getValue());
	}
	
	@Override
	public ModelAndView getManageTemplate(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_MANAGE_TEMP.getValue());
	}
	
	@Override
	public ModelAndView getManageSub(HttpServletRequest request, HttpSession session) {
		if(!loginService.isLogin(session)) {
			return new ModelAndView(Redirect.ADMIN_LOGIN.getValue());
		}
		return new ModelAndView(PageView.HOME_MANAGE_SUB.getValue());
	}
}
