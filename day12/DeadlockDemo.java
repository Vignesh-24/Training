package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es=Executors.newFixedThreadPool(2);
		Frog frog=new Frog();
		Crane crane=new Crane();
		es.execute(()->{
			crane.eat(frog);
		});
		
		es.execute(()->{
			frog.escape(crane);
		});
		
		es.shutdown();

	}

}


class Crane{
	public synchronized void eat(Frog frog) {
		System.out.println("Trying to Eat Frog");
		try {Thread.sleep(2000);}catch(Exception e) {}
		frog.leaveCrane();
		System.out.println("Ate Frog");
	}
	
	public synchronized void spitFrog() {
		
	}
}

class Frog{
	
	public synchronized void escape(Crane crane) {
		crane.spitFrog();
		
	}
	
	public synchronized void leaveCrane() {
		
	}
	
}