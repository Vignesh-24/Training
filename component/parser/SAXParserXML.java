package component.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class SAXParserXML  extends DefaultHandler{
	
	
	private InvoiceWrapper invoice;
	Item item=null;
	String curvalue;
	
	public SAXParserXML() {
		super();
		this.invoice = new InvoiceWrapper();
	}
	
	public InvoiceWrapper getInvoiceData() {
		return this.invoice;
	}
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document Parsing Started...!");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("item"))
			this.item=new Item();
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.curvalue=new String(ch,start,length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "custname":
			this.invoice.getCustomer().setName(curvalue);
			break;
		case "billno":
			this.invoice.getCustomer().setBillid(curvalue);break;
		case "billdate":
			this.invoice.getCustomer().setBilldate(curvalue);break;
		case "id":
			this.item.setId(Integer.parseInt(curvalue));break;
		case "name":
			this.item.setName(curvalue);break;
		case "unit":
			this.item.setUnit(Integer.parseInt(curvalue));break;
		case "price":
			this.item.setPrice(Integer.parseInt(curvalue));break;
		case "qty":
			this.item.setQty(Integer.parseInt(curvalue));break;
		case "amount":
			this.item.setAmount(Integer.parseInt(curvalue));break;
		case "item":
			this.invoice.add(this.item);
		
		default:
			break;
		}
	}
	
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println(this.invoice.getCustomer().toString());
		System.out.println(this.invoice.getItems().toString());
		System.out.println("Documemt Parsing Ended..!");
	}
	
	
}
