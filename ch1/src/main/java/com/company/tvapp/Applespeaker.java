package com.company.tvapp;

public class Applespeaker implements speaker {
	public Applespeaker()
	{
		System.out.println("AppleSepaker ��ü ����");
	}
	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker volume up");
	}

	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker volume Down");
	}

}
