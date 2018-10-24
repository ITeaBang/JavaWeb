package com.tm.androidphone.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.androidphone.domain.Item;

@Repository
public class ItemDAO {

	@Autowired
	private SqlSession sqlSession;

	// 테이블의 전체 데이터를 가져오는 메소드
	public List<Item> listItem() {
		return sqlSession.selectList("item.listItem");
	}
	
	// itemid를 가지고 하나의 데이터를 가져오는 메소드
	public Item getItem(int itemid) {
		return sqlSession.selectOne("item.getItem", itemid);
	}
}


