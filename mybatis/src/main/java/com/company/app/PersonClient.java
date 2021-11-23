package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.service.PersonService;

public class PersonClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonService service = (PersonService) ctx.getBean("person");
		
		System.out.println(service.insertPerson("choi123", "������")?"�Է¼���":"�Է½���");
		System.out.println(service.selecPerson("hong123"));
		System.out.println(service.updatePerson("hong123","���̼�")?"��������":"��������");
		System.out.println(service.deletePerson("hong123")?"��������":"��������");
	}

}
