package com.company.app;

import org.springframework.stereotype.Component;


@Component //��ü ����
public class Product {
	private String company;
	private String pname;
	private String price;
	public Product(String company, String pname, String price) {
		super();
		this.company = company;
		this.pname = pname;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void getInfo() throws Exception {
		System.out.println("");
		System.out.println("ȸ���" + company);
		System.out.println("��ǰ��" + pname);
		System.out.println("����" + price);
		throw new Exception();
	}
}
