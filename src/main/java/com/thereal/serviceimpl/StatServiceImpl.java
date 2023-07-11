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

import com.thereal.dao.StatDAO;
import com.thereal.model.dto.CodeDTO;
import com.thereal.model.dto.FailbackDTO;
import com.thereal.model.dto.SubDTO;
import com.thereal.service.StatService;
import com.thereal.util.LoginUtil;
import com.thereal.util.ResponseHttp;

@Service("statService")
public class StatServiceImpl implements StatService {
	
	private static final Logger logger = LogManager.getLogger(StatServiceImpl.class);
	
	@Autowired StatDAO statDAO;
	@Autowired LoginServiceImpl loginService;
	
	@Override
	public ResponseEntity selectTotal(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
			resMessage.put("datas", statDAO.selectCountStatus());
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
	
	
	@Override
	public ResponseEntity selectCountStatics(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {			
			List<CodeDTO> codeList = statDAO.selectCountCode();
//			int codeSize = codeList.size();
//			codeList.set(codeSize-1, 
//					codeList.get(codeSize - 1).builder().code("total").count(codeList.get(codeSize - 1).getCount()).build());
			resMessage.put("codeList", codeList);
			
			List<FailbackDTO> failbackList = statDAO.selectLmsCountCode();
//			int failbackSize = failbackList.size();
//			failbackList.set(failbackSize-1, 
//					failbackList.get(failbackSize - 1).builder().code("total").count(failbackList.get(failbackSize - 1).getCount()).build());
			resMessage.put("failbackList", failbackList);
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}

	@Override
	public ResponseEntity selectSubList(HttpServletRequest request, HttpSession session) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
			List<SubDTO> subList = statDAO.selectSubList();
			resMessage.put("datas", subList);
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}


	@Override
	public ResponseEntity selectCountStat(HttpServletRequest request, HttpSession session, String param) {
		Map<String, Object> resMessage = new HashMap<String, Object>();
		
		if(!loginService.isLogin(session)) {
			return ResponseHttp.status(resMessage, HttpStatus.UNAUTHORIZED);
		}
		
		try {
			List<CodeDTO> codeList = statDAO.selectCountCode(param);
			resMessage.put("codeList", codeList);
			
			List<FailbackDTO> failbackList = statDAO.selectLmsCountCode(param);
			resMessage.put("failbackList", failbackList);
		}
		catch (Exception e) {
			logger.error(e);
			return ResponseHttp.failed(resMessage);
		}
		
		return ResponseHttp.ok(resMessage);
	}
}
