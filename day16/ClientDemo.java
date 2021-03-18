package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		PrintWriter out;
		BufferedReader br,in;
		
		try {

			while(true) {
				socket=new Socket("localhost",2000);
				br=new BufferedReader(new InputStreamReader(socket.getInputStream()));         
				String msgFromServer=br.readLine();       
				System.out.println("Message From Server...:"+msgFromServer);
				
				
				out=new PrintWriter(socket.getOutputStream(),true);
				in=new BufferedReader(new InputStreamReader(System.in));       
				System.out.println("Please Enter a message to Server..:");         
				String msg=in.readLine();
				out.println(msg);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
