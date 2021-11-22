package ch3;

public class Tvuser {
	public static void main(String[] args) {

		
		TV tv = new SamsungTv();
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
		
		TV tv1 = new SamsungTv();
		
		System.out.println(tv ==tv1 ? "°´Ã¼ µ¿µî":"°´Ã¼ ´Ù¸§");
	}
}
