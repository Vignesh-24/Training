package utility;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import model.ItemMasterDTO;
import model.ItemTransactionDTO;
import utility.parser.InvoiceWrapper;


public class XmlCreator {
	
	public static void createXML(InvoiceWrapper wrapper){
		
		StringBuilder builder=new StringBuilder();
		File file=new File(String.valueOf(wrapper.getInvoice().getInvno())+".xml");
		if(file.exists())
			return;
		builder.append("<invoice>");
		builder.append("<invoiceno>"+wrapper.getInvoice().getInvno()+"</invoiceno>");
		builder.append("<invoicedate>"+wrapper.getInvoice().getInvdate().toString()+"</invoicedate>");
		builder.append("<customer>").append("<custname>"+wrapper.getCustomer().getCustomername()+"</custname>");
		builder.append("<custaddress>"+wrapper.getCustomer().getCustomeraddress()+"</custaddress>");
		builder.append("<customerphn>"+wrapper.getCustomer().getCustomerphone()+"</customerphn>");
		builder.append("<customeremail>"+wrapper.getCustomer().getCustomeremail()+"</customeremail>");
		builder.append("</customer>");
		
		builder.append("<items>");
		
		
		int qty,itemno;
		ItemMasterDTO item;
		Map<Integer, ItemMasterDTO> map=wrapper.getItemlist();
		for(ItemTransactionDTO trans: wrapper.getItemtrans()) {
			builder.append("<item>");
			itemno=trans.getItemno();
			qty=trans.getItemunit();
			item=map.get(itemno);
			builder.append("<itemno>"+item.getItemno()+"</itemno>");
			builder.append("<itemdesc>"+item.getItemdesc()+"</itemdesc>");
			builder.append("<unit>"+item.getItemqty()+"</unit>");
			builder.append("<itemprice>"+item.getItemprice()+"</itemprice>");
			builder.append("<qty>"+qty+"</qty>");
			builder.append("</item>");
		}
		builder.append("</items></invoice>");
		try (FileWriter writer=new FileWriter(file)){
			writer.write(builder.toString());
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
