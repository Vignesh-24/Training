package webservice;

import javax.xml.ws.Endpoint;

public class MTOMPublisher {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:3000/ws/hello", new MTOMImpl());
		System.out.println("service published at port 3000");

	}

}
