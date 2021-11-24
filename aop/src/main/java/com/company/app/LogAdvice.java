package com.company.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect 	//app ������̼� ���� ���
@Component("log")
public class LogAdvice {
	
	@Before(value= "execution(* com.company.app.Product.getInfo())")
	public void beforeLog() {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
	}
	
	@After(value= "execution(* com.company.app.Product.getInfo())")
	public void afterLog() {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ�� - ���ܿ� ������� ȣ��");
	}

	@AfterThrowing(value= "execution(* com.company.app.Product.getInfo())")
	public void afterThrowLog() {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ�� - ���� �߻��� ȣ��");
	}

	@AfterReturning(value= "execution(* com.company.app.Product.getInfo())")
	public void afterReturnLog() {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ�� - ���� ����� ȣ��");
	}

	@Around(value= "execution(* com.company.app.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[����α� ����Ͻ� ���� ���� �� ȣ��");

		try {
			pjp.proceed(); // ���� ������ �޼ҵ� ȣ��
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
	}
}
