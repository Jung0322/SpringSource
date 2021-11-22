package com.company.tvapp;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LGTv implements TV {
	
	//private SonySpeaker speaker = new SonySpeaker();
	//@Autowired // ������ ��ü�� ����(Speaker�� �����ϴ� ��� Ŭ������ ���)
	@Inject // Autowired�� ���� ���
	@Qualifier("apple") // �̸� ���� ��� �ۿ� ���� (������ ����� �������϶� ���)
	private speaker speaker;	// has-a : �ʱ�ȭ(������, setter)
	
	
	public LGTv() {
		System.out.println("LgTV ��ü ����");
	}
	
//	public LGTv(speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}	
//	
//	public void setSpeaker(speaker speaker) {
//		this.speaker = speaker;
//	}	
//	
	
	@Override
	public void turnOn() {
		System.out.println("LgTv - ���� On");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTv - ���� Off");
	}
	@Override
	public void soundUp() {
		//System.out.println("LgTv - ���� Up");
		//speaker = new SonySpeaker();
		speaker.volumUp();;
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTv - ���� Down");
		//speaker = new SonySpeaker();
		speaker.volumDown();
	}
}