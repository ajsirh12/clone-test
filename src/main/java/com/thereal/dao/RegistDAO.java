package com.thereal.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thereal.model.dto.ButtonDTO;
import com.thereal.model.dto.ChannelKeyDTO;
import com.thereal.model.dto.PhoneDTO;
import com.thereal.util.SqlSessionSelector;

@Repository("registDAO")
public class RegistDAO {
	private static final Logger logger = LogManager.getLogger(RegistDAO.class);
	
	@Autowired SqlSessionSelector sqlSessionSelector;
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "registMapper";
	
	private void init() {
		if(sqlSession == null) {
			logger.debug("AdminDAO init()");
			sqlSession = sqlSessionSelector.getSession();	
		}
	}
	
	public List<ChannelKeyDTO> ajaxChannels(){
		init();
		return sqlSession.selectList(namespace + ".ajaxChannels");
	}
	
	public List<PhoneDTO> ajaxPhones(){
		init();
		return sqlSession.selectList(namespace + ".ajaxPhones");
	}
	
	public List<ButtonDTO> ajaxButtons(){
		init();
		return sqlSession.selectList(namespace + ".ajaxButtons");
	}
	
	public int selectChannel() {
		init();
		return sqlSession.selectOne(namespace + ".selectChannel");
	}
	
	public int insertChannel() {
		init();
		return sqlSession.insert(namespace + ".insertChannel");
	}
	
	public int insertTemplate() {
		init();
		return sqlSession.insert(namespace + ".insertTemplate");
	}
	
	public int insertLMS() {
		init();
		return sqlSession.insert(namespace + ".insertLMS");
	}
	
	public int countBtn() {
		init();
		return sqlSession.selectOne(namespace + ".countBtn");
	}
	
	public int insertBtn() {
		init();
		return sqlSession.insert(namespace + ".insertbtn");
	}
	
	public int insertBtnList() {
		init();
		return sqlSession.insert(namespace + ".insertBtnList");
	}
}
