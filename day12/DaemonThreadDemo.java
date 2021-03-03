package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadDemo {
	
	public DaemonThreadDemo() {
		
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			int i=0;
			while(i<100) {
				System.out.println("Child Thread");
				i++;
			}
			//Thread.currentThread().setDaemon(true);
		});

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DaemonThreadDemo();
		System.out.println(Thread.currentThread());
		Thread.currentThread().setDaemon(true);
		System.exit(1);

	}

}


