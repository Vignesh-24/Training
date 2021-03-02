package day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object vicky=new Human();
		Scanner sc=new Scanner(System.in);
		System.out.println("God Help..");
		sc.next();
		JetAcademy jet=new JetAcademy();
		vicky=Proxy.newProxyInstance(Human.class.getClassLoader(), 
				new Class[] {Pilot.class},
				new MyInvocationHandler(jet));

		Pilot dpvicky=(Pilot)vicky;
		System.out.println("God Helpipng..");
		dpvicky.doFly();
		sc.close();

	}
	
	
		

}

class MyInvocationHandler implements InvocationHandler{
	
	Object obj;
	
	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(obj,args);
	}
	
}

class Human{
	public void doCry() {
		System.out.println("Human crying..!");
	}
}


interface Doctor{
	public void doCure();
}

interface Pilot{
	public void doFly();
}

interface Steward{
	public void doServe();
}



class Stanley implements Doctor{

	@Override
	public void doCure() {
		System.out.println("Do cure Stanley..");
		
	}
}



class Unani implements Doctor{

	@Override
	public void doCure() {
		System.out.println("Unani Doctor cure!!");
		
	}
}


class JetAcademy implements Pilot,Steward{

	@Override
	public void doServe() {
		System.out.println("Serving to passenger..");
		
	}

	@Override
	public void doFly() {
		System.out.println("flying is teached to pilot");
		
	}
	
}



