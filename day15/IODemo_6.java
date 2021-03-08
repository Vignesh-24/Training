package day15;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IODemo_6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PipedReader reader=new PipedReader();
		PipedWriter writer=new PipedWriter(reader);
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			try {
				int data=reader.read();
				while(data!=-1) {
					System.out.print((char)data);
					data=reader.read();
				}
				System.out.println();
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		es.execute(()->{
			try {
				while(true) {
					writer.write("I love my country".toCharArray());
					try {Thread.sleep(1000);}catch(Exception e) {							
					}
					System.out.println();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		

	}

}
