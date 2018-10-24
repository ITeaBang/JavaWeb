package com.tm.androidphone;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tm.androidphone.domain.Item;
import com.tm.androidphone.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	// URL 은 모두 소문자로 합니다.
	@RequestMapping(value="listitem", method=RequestMethod.GET)
	public List<Item> listItem(HttpServletRequest request){
		return itemService.listItem(request);
	}
	
	@RequestMapping(value="getitem", method=RequestMethod.GET)
	public Item getItem(HttpServletRequest request){
		return itemService.getItem(request);
	}
}
