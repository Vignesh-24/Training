package webservice;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class MySoapHandler implements SOAPHandler<SOAPMessageContext>{
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		
		Boolean result = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if(result) {
			System.out.println("out bound message-response");
			try {
				
				SOAPMessage soapMsg=context.getMessage();
				SOAPEnvelope soapEnv=soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader=soapEnv.getHeader();
				if(soapHeader==null){
					soapHeader=soapEnv.addHeader();
					generateSOAPErrMessage(soapMsg,"NoSOAP header.");
				}
				
				Iterator it=soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				if(it==null|| !it.hasNext()){generateSOAPErrMessage(soapMsg,"Noheader block for next actor.");}
				
				Node macNode= (Node)it.next();
				String macValue= (macNode==null) ?null:macNode.getValue();
				
				if(macValue==null){generateSOAPErrMessage(soapMsg,"Nomac address in header block.");}
				if(!macValue.equals("90-4C-E5-44-B9-8F1")){generateSOAPErrMessage(soapMsg,"Invalid mac address, access is denied.");}
				soapMsg.writeTo(System.out);
				
				
						
				PrintStream out=new PrintStream(System.out);
				soapMsg.writeTo(out);
				out.println();
				FileOutputStream os =new FileOutputStream("response.xml");
				soapMsg.writeTo(os);
			}catch(Exception e) {
					e.printStackTrace();
			}
			
		}
		else {
			
			System.out.println("in bound message-request");
			try {
				
				SOAPMessage sm=context.getMessage();
				PrintStream out=new PrintStream(System.out);
				sm.writeTo(out);
				out.println();
				FileOutputStream os =new FileOutputStream("request.xml");
				sm.writeTo(os);
			}catch(Exception e) {
					e.printStackTrace();
			}
			
		}
		System.out.println("Result...:"+result);
		
		return true;
	}
	
	
	private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
		
		try{
			SOAPBody soapBody=msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault=soapBody.addFault();
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);}catch(SOAPException e) { }
		
	}
	
	
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("Server :handleFault()......");
		return true;
	}
	@Override
	public void close(MessageContext context) {
		System.out.println("Server :close()......");
	}
	@Override
	public Set<QName> getHeaders() {
		System.out.println("called in the instantiation.....- headers.......");
		return null;
	}
	
}
