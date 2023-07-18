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
import com.thereal.model.entity.BtnEntity;
import com.thereal.model.entity.BtnListEntity;
import com.thereal.model.entity.LmsEntity;
import com.thereal.model.entity.TemplateEntity;
import com.thereal.model.vo.ChannelVO;
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
	
	public int selectChannel(ChannelVO vo) {
		init();
		return sqlSession.selectOne(namespace + ".selectChannel", vo);
	}
	
	public int insertChannel(ChannelVO vo) {
		init();
		return sqlSession.insert(namespace + ".insertChannel", vo);
	}
	
	public int insertTemplate(TemplateEntity entity) {
		init();
		return sqlSession.insert(namespace + ".insertTemplate", entity);
	}
	
	public int insertLMS(LmsEntity entity) {
		init();
		return sqlSession.insert(namespace + ".insertLMS", entity);
	}
	
	public int selectBtnSeq(BtnEntity entity) {
		init();
		return sqlSession.selectOne(namespace + ".selectBtnSeq", entity);
	}
	
	public int insertBtn(BtnEntity entity) {
		init();
		return sqlSession.insert(namespace + ".insertBtn", entity);
	}
	
	public int insertBtnList(BtnListEntity entity) {
		init();
		return sqlSession.insert(namespace + ".insertBtnList", entity);
	}
}
