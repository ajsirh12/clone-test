package com.thereal.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thereal.model.dto.TempDetailDTO;
import com.thereal.model.dto.TempListDTO;
import com.thereal.util.SqlSessionSelector;

@Repository("manageDAO")
public class ManageDAO {
private static final Logger logger = LogManager.getLogger(ManageDAO.class);
	
	@Autowired SqlSessionSelector sqlSessionSelector;
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "manageMapper";
	
	private void init() {
		if(sqlSession == null) {
			logger.debug("AdminDAO init()");
			sqlSession = sqlSessionSelector.getSession();	
		}
	}
	
	public List<TempListDTO> getTemplateList(){
		init();
		return sqlSession.selectList(namespace + ".getTemplateList");
	}
	
	public TempDetailDTO getTemplateDetail(String tempCode) {
		init();
		return sqlSession.selectOne(namespace + ".getTemplateDetail", tempCode);
	}
}
