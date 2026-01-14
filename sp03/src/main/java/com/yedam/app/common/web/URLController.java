package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Web과 관련된 Bean 등록
 * Route = EndPoint(Http Method + URI)
 * 		   + Service
 * 		   +  Return Type(View or Date)
 */
@Controller
public class URLController {
	// @RequestMapping(path = "/", method = RequestMethod.GET)
	@GetMapping("get")
	@ResponseBody // AJAX
	public String getMapping(String keyword) {
		return "[Get Method] keyword: " + keyword;
	}

	// @RequestMapping(path = "1557", method = RequestMethod.POST)
	@PostMapping("post")
	@ResponseBody
	public String postMapping(String keyword) {
		return "[Post Method] keyword: " + keyword;
	}

}
