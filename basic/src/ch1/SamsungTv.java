package ch1;

import ch2.TV;

public class SamsungTv implements TV{
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv - �Ŀ� On");
		
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv - �Ŀ� Off");
		
	}
	@Override
	public void soundUp() {
		System.out.println("SamsungTv - ���� Up");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv - ���� Down");
		
	}
}
