package com.company.tvapp;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements speaker {
	public SonySpeaker() {
		System.out.println("SonySpeaker ��ü ����");
	}
	@Override
	public void volumUp() {
		System.out.println("SonySpeaker -- ���� ��");
		
	}
	@Override
	public void volumDown() {
		System.out.println("SonySpeaker -- ���� �ٿ�");
		
	}
}
