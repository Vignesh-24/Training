package day16;

import java.net.InetAddress;


public class InetDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress ineta=InetAddress.getByName("www.irctc.co.in");
		System.out.println(ineta.getHostAddress());
			
		InetAddress inetarra[]=InetAddress.getAllByName("www.irctc.co.in"); 
		for(InetAddress a:inetarra) {       
			System.out.println(a.getHostAddress());    
		}
		

	}

}
