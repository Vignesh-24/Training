package webservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SOAPClient {

	public static void main(String[] args) throws MalformedURLException {
		
//		URL url=new URL("http://localhost:3000/ws/hello/?wsdl");
//		QName qName=new QName("http://webservice/", "HelloServiceImplService");
//		Service service=Service.create(url,qName);
//		HelloService hservice=service.getPort(HelloService.class);
//		String result=hservice.sayHello("Vicky");
//		System.out.println("The result is..:"+result);
		
		
		URL url=new URL("http://localhost:3000/ws/hello/?wsdl");
		QName qName=new QName("http://webservice/", "ComplexServiceImplService");
		Service service=Service.create(url,qName);
		ComplexService cService=service.getPort(ComplexService.class);
		System.out.println(cService.getEmployee("1").toString());
		cService.setEmployee(new Employee(3, "dhoni", 100000));
		System.out.println(cService.getAllEmployees().toString());

	}

}
