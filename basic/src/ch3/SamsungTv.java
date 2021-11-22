package ch3;


public class SamsungTv implements TV{
	
	public SamsungTv() {
		System.out.println("samsung Tv 按眉积己");
	}
	@Override
	public void turnOn() {
		System.out.println("SamsungTv - 颇况 On");
		
	}
	@Override
	public void turnOff() {
		System.out.println("SamsungTv - 颇况 Off");
		
	}
	@Override
	public void soundUp() {
		System.out.println("SamsungTv - 杭俘 Up");
		
	}
	@Override
	public void soundDown() {
		System.out.println("SamsungTv - 杭俘 Down");
		
	}
}
