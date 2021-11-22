package ch3;

public class LGTv implements TV {
	
	//private SonySpeaker speaker = new SonySpeaker();
	private speaker speaker;	// has-a : 초기화(생성자, setter)
	
	
	public LGTv() {
		System.out.println("LgTV 객체 생성");
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
		System.out.println("LgTv - 전원 On");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTv - 전원 Off");
	}
	@Override
	public void soundUp() {
		//System.out.println("LgTv - 볼륨 Up");
		//speaker = new SonySpeaker();
		speaker.volumUp();;
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTv - 볼륨 Down");
		//speaker = new SonySpeaker();
		speaker.volumDown();
	}
}
