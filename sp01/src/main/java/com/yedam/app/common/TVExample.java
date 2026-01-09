package com.yedam.app.common;

public class TVExample {
	public static void main(String[] args) {
		TV SamsungTV = new SamsungTV();
		TV LGTV = new LGTV();

		SamsungTV.powerOn();
		SamsungTV.volumeUp();
		SamsungTV.powerOff();
		
		LGTV.powerOn();
		LGTV.volumeUp();
		LGTV.powerOff();


	} // main
} // class
