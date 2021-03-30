package utility.sms;

import java.util.Map;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import model.ItemMasterDTO;
import model.ItemTransactionDTO;
import utility.parser.InvoiceWrapper;
import utility.parser.ParserHelper;


public class MessageSender implements XMLtoSMS {
	
	final String ACCOUNT_SID = "AC1f50b87bb7c56d21d8df8afcecee9877";
	final String AUTH_TOKEN = "b9e24762f517b1bb3d1a85a7a35336e1";

	@Override
	public void sendSMS(String to, String filename) throws Exception {
		
		InvoiceWrapper data=ParserHelper.getInvoiceData(filename);
		StringBuilder message=new StringBuilder();
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		message.append("Name:"+data.getCustomer().getCustomername()+" Items: ");
		int total=0;
		Map<Integer, ItemMasterDTO> map=data.getItemlist();
		for(ItemTransactionDTO itrans: data.getItemtrans()) {
			ItemMasterDTO item=map.get(itrans.getInvno());
			message.append("("+item.getItemdesc()+","+itrans.getItemunit()+","+item.getItemprice()*itrans.getItemunit()+"),");
			total+=item.getItemprice()*itrans.getItemunit();
		}
		 message.append("Total= ").append(total);
		 Message messageobj = Message.creator(new PhoneNumber(to),new PhoneNumber("+12107022886"), message.toString()).create();
	     System.out.println(messageobj.getSid());
		
	}

}
