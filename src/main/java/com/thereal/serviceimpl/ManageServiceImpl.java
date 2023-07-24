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

import com.thereal.dao.ManageDAO;
import com.thereal.model.dto.TempDetailDTO;
import com.thereal.service.ManageService;
import com.thereal.util.ResponseHttp;

@Service("manageService")
public class ManageServiceImpl implements ManageService {
	
	private static final Logger logger = LogManager.getLogger(ManageServiceImpl.class);
	
	@Autowired ManageDAO manageDAO;
	@Autowired
	private LoginServiceImpl loginService;
	
	@Override
	public ResponseEntity getTemplateList(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
			resMessage.put("templateList", manageDAO.getTemplateList());
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
	
	@Override
	public ResponseEntity getTemplateDetail(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		String tempCode;
		
		try {
			tempCode = request.getParameter("templateCode");
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		try {
			TempDetailDTO detailDTO = manageDAO.getTemplateDetail(tempCode);
			resMessage.put("tempDetail", detailDTO);
		}
		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
}
