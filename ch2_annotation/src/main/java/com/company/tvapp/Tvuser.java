package com.company.tvapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tvuser {
	public static void main(String[] args) {

		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		TV tv =(TV) ctx.getBean("samsung");
	
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
	}
}
