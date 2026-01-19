package com.yedam.app.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

// 모든 Controller에 공통적으로 적용
@ControllerAdvice
public class CommonControllerAdvice {
	// 모든 Page에 공통적으로 사용하는 변수
	@ModelAttribute("contextPath")
	public String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
}
