package com.thereal.util;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("sqlSessionSelector")
public class SqlSessionSelector {
	
	private static final Logger logger = LogManager.getLogger(SqlSessionSelector.class);
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;	
	@Resource(name = "sqlSessionTemplateTest")
	private SqlSessionTemplate sqlSessionTest;
	
	private static final ChkDevServer chkDev = ChkDevServer.getInstance();
	
	public SqlSessionTemplate getSession() {
		if(chkDev.isDev()) {
			return this.sqlSessionTest;
		}
		else {
			return this.sqlSession;
		}
	}
}
