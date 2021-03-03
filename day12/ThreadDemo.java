package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	ExecutorService es;
	public ThreadDemo() {
		// TODO Auto-generated constructor stub
		es=Executors.newFixedThreadPool(1);
		//Using New Class
		es.execute(new ThreadJob());
		
		//Using Lambda
		es.execute(()->{System.out.println("Lambda Thread Calledddd");});
		
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread curThread=Thread.currentThread();
		new ThreadDemo();
		System.out.println(curThread);
		for(int i=0;i<5;i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		
	}

}


class ThreadJob implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Child Thread Using class....");
		//this will be printed after 0
		
	}
	
}