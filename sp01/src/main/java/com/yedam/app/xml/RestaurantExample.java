package com.yedam.app.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RestaurantExample {
	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:xmlApplicationContext.xml");

		Restaurant res = ctx.getBean(Restaurant.class);
		res.run();

	} // main
} // class
