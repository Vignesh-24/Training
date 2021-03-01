package day7;

public class CommandRemote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv sony=new Tv();
		VGame vGame=new VGame();
		SetTopBox tata=new SetTopBox();
		SoundSystem ss=new SoundSystem();
		
		RemoteCommand fatherNewsRemoteCommand=new NewsChannelRemoteCommand(sony, tata, vGame, ss);
		RemoteCommand motherSerialRemoteCommand=new SerialTvRemoteCommand(sony, tata, vGame, ss);
		RemoteCommand fatherTennisRemoteCommand=new PlayTennisRemoteCommand(sony, tata, vGame, ss);
		
		UniversalRemote uremote=new UniversalRemote();
		uremote.setRemoteCommand(fatherTennisRemoteCommand, 0);
		uremote.setRemoteCommand(fatherNewsRemoteCommand, 1);
		uremote.setRemoteCommand(motherSerialRemoteCommand, 2);
		uremote.executeRemoteCommand(0);
		uremote.executeRemoteCommand(1);

	}

}



class UniversalRemote{
	RemoteCommand RemoteCommand[]=new RemoteCommand[5];
	public UniversalRemote() {
		for(int i=0;i<5;i++) {
			RemoteCommand[i]=new DummyRemoteCommand();
		}
	}
	
	public void executeRemoteCommand(int slot) {
		RemoteCommand[slot].execute();
	}
	
	public void setRemoteCommand(RemoteCommand c,int slot) {
		RemoteCommand[slot]=c;
	}
	class DummyRemoteCommand extends RemoteCommand{	
		@Override
		public void execute() {
			System.out.println("dummy RemoteCommand.........I am yet to be operational...");
		}
	}
}
abstract class RemoteCommand{
	Tv sony;SetTopBox tata;VGame vGame;SoundSystem ss;
	public RemoteCommand() {
		// TODO Auto-generated constructor stub
	}
	public RemoteCommand(Tv sony, SetTopBox tata, VGame vGame, SoundSystem ss) {
		this.sony = sony;
		this.tata = tata;
		this.vGame = vGame;
		this.ss = ss;
	}
	
	
	public abstract void execute();
}
class NewsChannelRemoteCommand extends RemoteCommand{
	public NewsChannelRemoteCommand(Tv sony, SetTopBox tata, VGame vGame, SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		System.out.println("News channel Command process starts..........");
		//i will write the logic...
		sony.switchOn();
		sony.av1Mode();
		ss.highSound();
		tata.newsChannel();
		System.out.println("Process over.....Watch the news....");
	}
}
class PlayTennisRemoteCommand extends RemoteCommand{
	public PlayTennisRemoteCommand(Tv sony, SetTopBox tata, VGame vGame, SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		System.out.println("Xbox play tennis Command process started....");
		sony.switchOn();
		sony.av1Mode();
		ss.highSound();
		vGame.playTennis();
		System.out.println("enjoy playing tennis sir.....");
	}
}
class SerialTvRemoteCommand extends RemoteCommand{
	public SerialTvRemoteCommand(Tv sony, SetTopBox tata, VGame vGame, SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		System.out.println("serial tv channel process started fro amma...");
		sony.switchOn();
		sony.av1Mode();
		tata.serialChannel();
		ss.lowSound();
		System.out.println("enjoy the saas bahu fighting serial.....");
	}
}
class Tv{
	public void switchOn() {
		System.out.println("tv is swtiched on...");
	}
	public void av1Mode() {
		System.out.println("av1 mode on....");
	}
}
class SetTopBox{
	public void newsChannel() {
		System.out.println("news channel on...");
	}
	public void serialChannel() {
		System.out.println("serial channel on...");
	}
}
class SoundSystem{
	public void lowSound() {
		System.out.println("low sound.......");
	}
	public void highSound() {
		System.out.println("high sound.......");
	}
}
class VGame{
	public void playTennis() {
		System.out.println("play tennis.......");
	}
}