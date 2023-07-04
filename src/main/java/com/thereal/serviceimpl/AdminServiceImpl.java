package com.thereal.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thereal.dao.AdminDAO;
import com.thereal.domain.vo.ChannelVO;
import com.thereal.domain.vo.PhoneVO;
import com.thereal.domain.vo.TemplateVO;
import com.thereal.service.AdminService;
import com.thereal.util.LoginUtil;
import com.thereal.util.ResponseHttp;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);
	
	@Autowired AdminDAO adminDAO;
	
	@Override
	public ResponseEntity postLogin(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		String user = "";
		String pwd = "";
		String enc = "";
		try {
			user = request.getParameter("user");
			pwd = request.getParameter("pwd");
			enc = adminDAO.selectUser(user);
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		try {
			if(LoginUtil.doLogin(user, pwd, enc)) {
				session.setAttribute("key01", user);
				session.setAttribute("key02", enc);
				return ResponseHttp.ok(resMessage);
			}
			else {
				return ResponseHttp.failed(resMessage);
			}	
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
	}

	@Override
	public ResponseEntity getPhoneList(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!LoginUtil.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
//			List<PhoneEntity> phoneList = adminDAO.selectPhoneList();
//			resMessage.put("datas", phoneList);
			
			resMessage.put("datas", adminDAO.selectPhoneList());
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}

	@Override
	public ResponseEntity postPhoneList(HttpServletRequest request, HttpSession session, PhoneVO vo) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!LoginUtil.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		logger.debug(vo.toString());
		
		try {
			if(adminDAO.insertPhone(vo) == 0) {
				return ResponseHttp.failed(resMessage);
			}
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity getChannelList(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!LoginUtil.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		try {
//			List<ChannelEntity> channelList = adminDAO.selectChannelList();
//			resMessage.put("datas", channelList);
			
			resMessage.put("datas", adminDAO.selectChannelList());
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}

	@Override
	public ResponseEntity postChannelList(HttpServletRequest request, HttpSession session, ChannelVO vo) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!LoginUtil.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		logger.debug(vo.toString());
		
		try {
			if(adminDAO.insertChannel(vo) == 0) {
				return ResponseHttp.failed(resMessage);
			}
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity getTemplateList(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!LoginUtil.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		try {
			resMessage.put("datas", adminDAO.selectTemplateList());
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}

	@Override
	public ResponseEntity postTemplateList(HttpServletRequest request, HttpSession session, TemplateVO vo) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!LoginUtil.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
			if(adminDAO.insertTemplate(vo) == 0) {
				return ResponseHttp.failed(resMessage);
			}
			if(adminDAO.insertSub(vo) == 0) {
				return ResponseHttp.failed(resMessage);
			}
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
}
