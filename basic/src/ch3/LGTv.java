package ch3;

public class LGTv implements TV {
	
	//private SonySpeaker speaker = new SonySpeaker();
	private speaker speaker;	// has-a : �ʱ�ȭ(������, setter)
	
	
	public LGTv() {
		System.out.println("LgTV ��ü ����");
	}
	
	public LGTv(speaker speaker) {
		super();
		this.speaker = speaker;
	}	
	
	public void setSpeaker(speaker speaker) {
		this.speaker = speaker;
	}	
	
	
	@Override
	public void turnOn() {
		System.out.println("LgTv - ���� On");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTv - ���� Off");
	}
	@Override
	public void soundUp() {
		//System.out.println("LgTv - ���� Up");
		//speaker = new SonySpeaker();
		speaker.volumUp();;
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTv - ���� Down");
		//speaker = new SonySpeaker();
		speaker.volumDown();
	}
}
