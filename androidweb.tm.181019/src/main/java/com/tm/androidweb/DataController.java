package com.tm.androidweb;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// html 대신에 csv나 json을 리턴하는 Controller을 만들어주는 Annotation
@RestController
public class DataController {

	@RequestMapping(value="data.csv", method=RequestMethod.GET)
	public String csv (HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		return "taeyeon, 수지, irin, iu";
	}
}
