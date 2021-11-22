package ch3;

public class SonySpeaker implements speaker {
	public SonySpeaker() {
		System.out.println("SonySpeaker °´Ã¼ »ý¼º");
	}
	@Override
	public void volumUp() {
		System.out.println("SonySpeaker -- º¼·ý ¾÷");
		
	}
	@Override
	public void volumDown() {
		System.out.println("SonySpeaker -- º¼·ý ´Ù¿î");
		
	}
}
