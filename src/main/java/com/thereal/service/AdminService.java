package com.thereal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.thereal.model.vo.ChannelVO;
import com.thereal.model.vo.PhoneVO;
import com.thereal.model.vo.TemplateVO;

public interface AdminService {
	public ResponseEntity postLogin(HttpServletRequest request, HttpSession session);
	
	public ResponseEntity getPhoneList(HttpServletRequest request, HttpSession session);
	public ResponseEntity postPhoneList(HttpServletRequest request, HttpSession session, PhoneVO vo);
	
	public ResponseEntity getChannelList(HttpServletRequest request, HttpSession session);
	public ResponseEntity postChannelList(HttpServletRequest request, HttpSession session, ChannelVO vo);
	
	public ResponseEntity getTemplateList(HttpServletRequest request, HttpSession session);
	public ResponseEntity postTemplateList(HttpServletRequest request, HttpSession session, TemplateVO vo);
}
