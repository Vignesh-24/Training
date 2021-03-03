package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorFactory {
	static Thread thread;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService ess=Executors.newFixedThreadPool(2,new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				System.out.println("Hi Thread...");
				thread=Executors.defaultThreadFactory().newThread(r);
				return thread;
			}
		});
		
		ess.execute(()->{System.out.println("thread 1 called...........");});
		System.out.println(thread.getName());
		ess.execute(()->{System.out.println("thread 2 called...........");});
		System.out.println(thread.getName());
		ess.shutdown();

	}

}
