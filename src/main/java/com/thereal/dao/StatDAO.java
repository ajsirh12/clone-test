package com.thereal.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thereal.domain.dto.CodeDTO;
import com.thereal.domain.dto.FailbackDTO;
import com.thereal.domain.dto.StatusDTO;
import com.thereal.domain.dto.SubDTO;
import com.thereal.util.SqlSessionSelector;

@Repository("statDAO")
public class StatDAO {

	private static final Logger logger = LogManager.getLogger(StatDAO.class);
	
	@Autowired SqlSessionSelector sqlSessionSelector;
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "statMapper";
	
	private void init() {
		if(sqlSession == null) {
			logger.debug("AdminDAO init()");
			sqlSession = sqlSessionSelector.getSession();	
		}
	}
	
	public List<StatusDTO> selectCountStatus(){
		init();
		return sqlSession.selectList(namespace + ".selectCountStatus");
	}
	
	public List<CodeDTO> selectCountCode(){
		init();
		return sqlSession.selectList(namespace + ".selectCountCode");
	}
	
	public List<FailbackDTO> selectLmsCountCode(){
		init();
		return sqlSession.selectList(namespace + ".selectLmsCountCode");
	}
	
	public List<SubDTO> selectSubList(){
		init();
		return sqlSession.selectList(namespace + ".selectSubList");
	}
	
	public List<CodeDTO> selectCountCode(String param){
		init();
		return sqlSession.selectList(namespace + ".selectCountCodeSub", param);
	}
	
	public List<FailbackDTO> selectLmsCountCode(String param){
		init();
		return sqlSession.selectList(namespace + ".selectLmsCountCodeSub", param);
	}
}
