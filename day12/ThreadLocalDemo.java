package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			LapTop laptop=EYOffice.getLapTopFromLockerRoom("ramu");
			LapTop laptop2=EYOffice.getLapTopFromLockerRoom("ramu");
			
			EYOffice.closeMyLapTop();
			
			EYOffice.getLapTopFromLockerRoom("ramu");
		});
		es.execute(()->{
			LapTop laptop11=EYOffice.getLapTopFromLockerRoom("somu");
			EYOffice.getLapTopFromLockerRoom("somu");
			EYOffice.getLapTopFromLockerRoom("somu");
			EYOffice.getLapTopFromLockerRoom("somu");
			EYOffice.getLapTopFromLockerRoom("somu");
		});
		es.shutdown();

	}

}


class EYOffice{
	
	private static ThreadLocal<LapTop> locker=new ThreadLocal<>();
	
	public static LapTop getLapTopFromLockerRoom(String name) {
			LapTop laptop=(LapTop)locker.get();
			if(laptop==null) {
				laptop=new LapTop(name);
				locker.set(laptop);
			}
			return laptop;
	}
	
	public static void closeMyLapTop() {
		LapTop laptop=(LapTop)locker.get();
		if(laptop!=null) {
			locker.remove();
		}
	}
}


class LapTop{
	
	String name;
	public LapTop(String name) {
		System.out.println("Laptop created....");
		this.name=name;
	}
	
	@Override
	public String toString() {
		return "Laptop belongs to..:"+name;
	}	
}