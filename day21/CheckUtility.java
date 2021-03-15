package day21;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CheckUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			System.out.println(DBUtiility.getConnection());
			System.out.println(DBUtiility.getConnection());
		});
		
		es.execute(()->{
			System.out.println(DBUtiility.getConnection());
			DBUtiility.closeConnection(null);
			System.out.println(DBUtiility.getConnection());
			
		});
		
		es.shutdown();


	}

}
