package com.thereal.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thereal.dao.RegistDAO;
import com.thereal.model.dto.ButtonDTO;
import com.thereal.model.dto.ChannelKeyDTO;
import com.thereal.model.dto.PhoneDTO;
import com.thereal.service.RegistService;
import com.thereal.util.ResponseHttp;

@Service("registService")
public class RegistServiceImpl implements RegistService {

	private static final Logger logger = LogManager.getLogger(RegistServiceImpl.class);
	
	@Autowired
	private RegistDAO registDAO;
	@Autowired
	private LoginServiceImpl loginService;
	
	@Override
	public ResponseEntity ajaxChannels(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		List<ChannelKeyDTO> channelList = registDAO.ajaxChannels();
		resMessage.put("channelList", channelList);
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity ajaxPhones(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}

		List<PhoneDTO> phoneList = registDAO.ajaxPhones();
		resMessage.put("phoneList", phoneList);
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity ajaxButtons(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}

		List<ButtonDTO> btnList = registDAO.ajaxButtons();
		resMessage.put("btnList", btnList);
		
		return ResponseHttp.ok(resMessage);
	}
}
