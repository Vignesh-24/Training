package webservice;

import javax.xml.ws.Endpoint;

public class UserAuthPublisher {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:3000/ws/hello", new HelloWorldImpl());
		System.out.println("service published at port 3000");

	}

}
