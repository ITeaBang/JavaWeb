package com.tm.mobileweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.mobileweb.dao.GoodDao;
import com.tm.mobileweb.domain.Good;
@Service
public class GoodServiceImpl implements GoodService {
	
	@Autowired
	private GoodDao goodDao;
	
	@Override
	public List<Good> list() {
		
		return goodDao.list();
	}

}
