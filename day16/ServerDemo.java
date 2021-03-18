package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		ServerSocket serverSocket;
		PrintWriter out;
		BufferedReader br,in;
		
		try {
			serverSocket=new ServerSocket(2000);
			System.out.println("Server Ready to acept..");
			while(true) {
				socket=serverSocket.accept();
				System.out.println(socket);
				
				out=new PrintWriter(socket.getOutputStream(),true);
				in=new BufferedReader(new InputStreamReader(System.in));       
				System.out.println("Please Enter a message to Client..:");         
				String msg=in.readLine();
				out.println(msg);
				
				br=new BufferedReader(new InputStreamReader(socket.getInputStream()));         
				String msgFromClient=br.readLine();       
				System.out.println("Message From Client...:"+msgFromClient);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
