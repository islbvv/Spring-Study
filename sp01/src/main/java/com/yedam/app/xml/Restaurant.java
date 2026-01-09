package com.yedam.app.xml;

public class Restaurant {
	// 필드
	private Chef chef;

	// 생성자
	public Restaurant() {
	}

	public Restaurant(Chef chef) {
		this.chef = chef;
	}

	// 메서드
	public void run() {
		chef.cooking();
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

} // class
