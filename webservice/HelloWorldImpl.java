package webservice;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "webservice.HelloWorld")
@HandlerChain(file = "handler-chain.xml")
public class HelloWorldImpl implements HelloWorld{
	@Resource
	WebServiceContext wsctx;

	@SuppressWarnings("rawtypes")
	@WebMethod
	@Override
	public String getHelloWorldAsString() {
		MessageContext mctx=wsctx.getMessageContext();
		Map http_headers= (Map)mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList= (List)http_headers.get("Username"); 
		List passList= (List)http_headers.get("Password");
		String username="";
		String password="";
		if(userList!=null){
			username=userList.get(0).toString();
		}
		if(passList!=null){
			password=passList.get(0).toString();
		}
		
		if(username.equals("vicky") && password.equals("secret"))
		{return"Hello World JAX-WS-Valid User!";}
		else {
			return "unknown";
		}
	}
	

}
