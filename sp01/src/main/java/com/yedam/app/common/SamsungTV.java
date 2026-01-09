package com.yedam.app.common;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("[삼성] TV를 켭니다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("[삼성] TV의 소리를 높힙니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("[삼성] TV를 끕니다.");
	}

}
