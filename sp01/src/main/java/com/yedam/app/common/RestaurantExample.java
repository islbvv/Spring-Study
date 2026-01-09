package com.yedam.app.common;

public class RestaurantExample {
	public static void main(String[] args) {

		Chef chef = new Chef();
		
		Restaurant res = new Restaurant(chef);
		res.run();

		Restaurant sec = new Restaurant(chef);
		sec.setChef(chef);
		sec.run();
	} // main
} // class
