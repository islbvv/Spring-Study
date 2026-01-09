package com.yedam.app.anotation;

import org.springframework.stereotype.Component;

@Component // 빈으로 등록할 클래스임을 명시
public class Chef {
	public Chef() {
		System.out.println("[Chef] 생성자 실행");
	}

	public void cooking() {
		System.out.println("[Chef] 요리를 합니다.");
	}
} // class
