package com.company.tvapp;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LGTv implements TV {
	
	//private SonySpeaker speaker = new SonySpeaker();
	//@Autowired // 생성된 객체를 주입(Speaker를 구현하는 모든 클래스가 대상)
	@Inject // Autowired와 같은 기능
	@Qualifier("apple") // 이름 지정 기능 밖에 없음 (주입할 대상이 여러개일때 사용)
	private speaker speaker;	// has-a : 초기화(생성자, setter)
	
	
	public LGTv() {
		System.out.println("LgTV 객체 생성");
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
		System.out.println("LgTv - 전원 On");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTv - 전원 Off");
	}
	@Override
	public void soundUp() {
		//System.out.println("LgTv - 볼륨 Up");
		//speaker = new SonySpeaker();
		speaker.volumUp();;
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTv - 볼륨 Down");
		//speaker = new SonySpeaker();
		speaker.volumDown();
	}
}