package ch1;

import ch2.TV;

public class SamsungTv implements TV{
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv - ÆÄ¿ö On");
		
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv - ÆÄ¿ö Off");
		
	}
	@Override
	public void soundUp() {
		System.out.println("SamsungTv - º¼·ý Up");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTv - º¼·ý Down");
		
	}
}
