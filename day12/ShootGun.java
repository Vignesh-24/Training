package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShootGun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gun pistolGun=new Gun();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			for(int i=0;i<5;i++) {
				pistolGun.fill();}
		});
		
		es.execute(()->{
			for(int i=0;i<5;i++) {
				pistolGun.shoot();}
		});

		es.shutdown();
	}

}



class Gun{
	
	private Boolean flag=false;
	synchronized public void fill() {
		
		if(flag) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Filling Shoot Gun....");
		flag=true;
		notify();
	}
	
	synchronized public void shoot() {
		
		if(!flag) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Shooting the Target....");
		flag=false;
		notify();
	}
	
	
	
	
	
	
}