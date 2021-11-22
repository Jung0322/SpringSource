package ch2;

public class Tvuser {
	public static void main(String[] args) {
//		SamsungTv tv = new SamsungTv();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		TV tv = new LGTv();
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
	}
}
