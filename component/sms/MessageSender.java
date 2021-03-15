package component.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import component.parser.InvoiceWrapper;
import component.parser.Item;
import component.parser.ParserHelper;

public class MessageSender implements XMLtoSMS {
	
	public static final String ACCOUNT_SID = "AC1f50b87bb7c56d21d8df8afcecee9877";
	public static final String AUTH_TOKEN = "13e3e4aec985f8938393a7ce2befe3ca";

	@Override
	public void sendSMS(String to, String filename) throws Exception {
		
		InvoiceWrapper data=ParserHelper.getInvoiceData(filename);
		StringBuilder message=new StringBuilder();
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		message.append("Name:"+data.getCustomer().getName()+" Items: ");
		int total=0;
		for(Item item: data.getItems()) {
			message.append("("+item.getName()+","+item.getQty()+","+item.getAmount()+"),");
			total+=item.getAmount();
		}
		 message.append("Total= ").append(total);
		 Message messageobj = Message.creator(new PhoneNumber(to),new PhoneNumber("+12107022886"), message.toString()).create();
	     System.out.println(messageobj.getSid());
		
	}

}
