package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		System.out.println("=========== ������ �����̳� ���� ��=========");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
		
		System.out.println("=========== ������ �����̳� ���� ===========");
		
		//������ �����̳ʷκ��� �ʿ��� ��ü�� ��û
		MessageBean msg = (MessageBean) ctx.getBean("ko");
		msg.sayHello("ȫ�浿");
		
	}

}
