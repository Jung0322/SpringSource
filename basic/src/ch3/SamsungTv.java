package ch3;


public class SamsungTv implements TV{
	
	public SamsungTv() {
		System.out.println("samsung Tv ��ü����");
	}
	@Override
	public void turnOn() {
		System.out.println("SamsungTv - �Ŀ� On");
		
	}
	@Override
	public void turnOff() {
		System.out.println("SamsungTv - �Ŀ� Off");
		
	}
	@Override
	public void soundUp() {
		System.out.println("SamsungTv - ���� Up");
		
	}
	@Override
	public void soundDown() {
		System.out.println("SamsungTv - ���� Down");
		
	}
}
