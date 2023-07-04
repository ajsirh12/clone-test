package com.thereal.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thereal.domain.dto.TemplateDTO;
import com.thereal.domain.entity.ChannelEntity;
import com.thereal.domain.entity.PhoneEntity;
import com.thereal.domain.vo.ChannelVO;
import com.thereal.domain.vo.PhoneVO;
import com.thereal.domain.vo.TemplateVO;
import com.thereal.util.SqlSessionSelector;

@Repository("adminDAO")
public class AdminDAO {
	private static final Logger logger = LogManager.getLogger(AdminDAO.class);
	
	@Autowired SqlSessionSelector sqlSessionSelector;
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "adminMapper";
	
	private void init() {
		if(sqlSession == null) {
			logger.debug("AdminDAO init()");
			sqlSession = sqlSessionSelector.getSession();	
		}
	}
	
	public List<Map<String, Object>> selectTest(){
		init();
		return sqlSession.selectList(namespace + ".selectTest");
	}
	
	public String selectUser(String user) {
		init();
		return sqlSession.selectOne(namespace + ".selectUser", user);
	}
	
	public List<PhoneEntity> selectPhoneList(){
		init();
		return sqlSession.selectList(namespace + ".selectPhoneList");
	}
	
	public List<ChannelEntity> selectChannelList(){
		init();
		return sqlSession.selectList(namespace + ".selectChannelList");
	}
	
	public List<TemplateDTO> selectTemplateList(){
		init();
		return sqlSession.selectList(namespace + ".selectTemplateList");
	}
	
	public int insertPhone(PhoneVO vo) {
		init();
		return sqlSession.insert(namespace + ".insertPhone", vo);
	}
	public int insertChannel(ChannelVO vo) {
		init();
		return sqlSession.insert(namespace + ".insertChannel", vo);
	}
	public int insertSub(TemplateVO vo) {
		init();
		return sqlSession.insert(namespace + ".insertSub", vo);
	}
	public int insertTemplate(TemplateVO vo) {
		init();
		return sqlSession.insert(namespace + ".insertTemplate", vo);
	}
}
