package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface AdminViewService {
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session);
	public ModelAndView getMain(HttpServletRequest request, HttpSession session);
	public ModelAndView getTemplate(HttpServletRequest request, HttpSession session);
	public ModelAndView getStatistic(HttpServletRequest request, HttpSession session);
	
	ModelAndView getRegist(HttpServletRequest request, HttpSession session);
	ModelAndView getRegistSub(HttpServletRequest request, HttpSession session);
	
	ModelAndView getManageTemplate(HttpServletRequest request, HttpSession session);
	ModelAndView getManageSub(HttpServletRequest request, HttpSession session);
}
