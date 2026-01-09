package com.yedam.app.java;

public class Restaurant {
	// 필드
	private Chef chef;

	// 생성자
	public Restaurant() {
		System.out.println("[Restaurant] 생성자 실행");
	}

	public Restaurant(Chef chef) {
		System.out.println("[Restaurant] 생성자 실행");
		this.chef = chef;
	}

	// 메서드
	public void run() {
		chef.cooking();
	}

	public void setChef(Chef chef) {
		System.out.println("[Restaurant] 세터 실행");
		this.chef = chef;
	}

} // class
