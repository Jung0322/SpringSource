package ch2;

public class LGTv implements TV {
	@Override
	public void turnOn() {
		System.out.println("LGTv - ���� On");
	}
	@Override
	public void turnOff() {
		System.out.println("LGTv - ���� Off");
	}
	@Override
	public void soundUp() {
		System.out.println("LGTv - ���� Up");
	}	
	@Override
	public void soundDown() {
		System.out.println("LGTv - ���� Down");
	}
}
