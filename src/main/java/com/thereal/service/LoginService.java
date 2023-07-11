package com.thereal.service;

import javax.servlet.http.HttpSession;

import com.thereal.model.dto.TokenDTO;

public interface LoginService {
	int updateToken(TokenDTO dto);
	boolean isLogin(HttpSession session);
}
