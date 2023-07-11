package com.thereal.serviceimpl;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thereal.dao.AdminDAO;
import com.thereal.model.dto.TokenDTO;
import com.thereal.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);
	
	@Autowired AdminDAO adminDAO;
	
	@Override
	public int updateToken(TokenDTO dto) {
		return adminDAO.updateToken(dto);
	}
	
	@Override
	public boolean isLogin(HttpSession session) {
		try {
			String token = session.getAttribute("key01").toString();
			if(adminDAO.isLogin(token) == 0) {
				session.invalidate();
				return false;
			}
			else {
				session.setMaxInactiveInterval(900);
				return true;
			}
		}
		catch (NullPointerException e) {
			return false;
		}		
	}
}
