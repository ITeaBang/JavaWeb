package com.tm.mobileweb;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tm.mobileweb.dao.GoodDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestClass {
	
	@Inject
	private SqlSession sqlSession;
		
	@Autowired
	private GoodDao goodDao;
	
	@Test
	public void method(){
		System.out.println(sqlSession);
		System.out.println(goodDao.list());
	}
}
