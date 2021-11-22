package ch1;

public class Tvuser {
	public static void main(String[] args) {
//		SamsungTv tv = new SamsungTv();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		LGTv tv = new LGTv();
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
	}
}
