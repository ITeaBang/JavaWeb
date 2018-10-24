package com.tm.androidphone.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tm.androidphone.domain.Item;

// 리턴 타입은 보통의 경우는 Dao 메소드와 일치, 매개 변수의 가장 편리한 방법은 HttpServletRequest, 파일이 있을 때 경우 앞에 Multipart 입력
public interface ItemService {

	public List<Item> listItem(HttpServletRequest request);
	public Item getItem(HttpServletRequest request);

}
