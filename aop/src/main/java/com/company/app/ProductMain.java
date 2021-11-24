package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Product product = (Product) ctx.getBean("product");
		product.setCompany("LEGO");
		product.setPname("LEGO ����");
		product.setPrice("100000");
		product.getInfo();
	}

}