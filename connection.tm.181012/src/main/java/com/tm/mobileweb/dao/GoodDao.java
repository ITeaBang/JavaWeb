package com.tm.mobileweb.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.mobileweb.domain.Good;

@Repository
public class GoodDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Good> list(){
		return sqlSession.selectList("goods.list");
	}
}
