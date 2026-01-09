package com.yedam.app.xml;

public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("[LG] TV를 켭니다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("[LG] TV의 소리를 높힙니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("[LG] TV를 끕니다.");
	}

}
