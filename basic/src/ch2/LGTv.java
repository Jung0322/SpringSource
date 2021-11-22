package ch2;

public class LGTv implements TV {
	@Override
	public void turnOn() {
		System.out.println("LGTv - Àü¿ø On");
	}
	@Override
	public void turnOff() {
		System.out.println("LGTv - Àü¿ø Off");
	}
	@Override
	public void soundUp() {
		System.out.println("LGTv - º¼·ý Up");
	}	
	@Override
	public void soundDown() {
		System.out.println("LGTv - º¼·ý Down");
	}
}
