package webservice;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class HelloWorldClient {

	public static void main(String[] args) throws Exception {
		
		URL url =new URL("http://localhost:3000/ws/hello?wsdl");
		QName qname =new QName("http://webservice/","HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld hello=service.getPort(HelloWorld.class);
		
		Map<String, Object> req_ctx=((BindingProvider)hello).getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"http://localhost:3000/ws/hello?wsdl");
		Map<String, List<String>> headers=new HashMap<String, List<String>>();
		headers.put("Username",Collections.singletonList("vicky"));
		headers.put("Password",Collections.singletonList("secret"));
		
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS,headers);
		System.out.println(hello.getHelloWorldAsString());
	}

}
