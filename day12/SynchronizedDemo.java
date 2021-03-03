package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedDemo {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ExecutorService es=Executors.newFixedThreadPool(2);
		ReservationCounter counter=new ReservationCounter();
		es.execute(()->{
			synchronized (counter) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.currentThread().setName("Vicky");
				counter.book(500);
				counter.giveChange(500);
			
			}
		});
		
		es.execute(()->{
			synchronized (counter) {
				Thread.currentThread().setName("Lulu");
				counter.book(1000);
				counter.giveChange(1000);
			
			}
		});
		es.shutdown();

	}

}


class ReservationCounter{
	
	public void book(int amount) {
		String name=Thread.currentThread().getName();
		System.out.println("Ticket Booking..."+name+"\nAmount..."+amount);

	}
	
	public void giveChange(int amt) {
		String name=Thread.currentThread().getName();
		System.out.println("Change issued..."+name+"\nAmount..."+(amt-10));
	}
}