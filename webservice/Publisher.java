package webservice;

import javax.xml.ws.Endpoint;

public class Publisher {

	public static void main(String[] args) {
		
		//Endpoint.publish("http://localhost:3000/ws/hello/", new HelloServiceImpl());
		Endpoint.publish("http://localhost:3000/ws/hello/", new ComplexServiceImpl());
		System.out.println("service published at port 3000");

	}

}
