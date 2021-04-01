package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "webservice.HelloService")
public class HelloServiceImpl implements HelloService{
	
	@WebMethod
	@Override
	public String sayHello(String name) {
		
		return "Welcome to SOAP...."+name;
	}

}
